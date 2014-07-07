package com.ratzia.pfc.webpageanalyticaltool



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import java.util.regex.Pattern
import wslite.soap.*
import grails.converters.*

import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_FULLY'])
@Transactional(readOnly = true)
class CrawlerSessionController {
    def grailsApplication
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CrawlerSession.list(params), model:[crawlerSessionInstanceCount: CrawlerSession.count()]
    }

    def show(CrawlerSession crawlerSessionInstance) {
        respond crawlerSessionInstance
    }
    
    def ajaxCrawlerStatus(CrawlerSession crawlerSessionInstance) {
        def result = ['status':crawlerSessionInstance.status.toString(), 'pageCount':crawlerSessionInstance.pageCount]
        render result as JSON
    }
    
    @Transactional(rollbackFor = java.net.ConnectException.class)
    def stop(CrawlerSession crawlerSessionInstance) {
        crawlerSessionInstance.status = "stopping"
        crawlerSessionInstance.save flush:true
        def stopCrawlerResponse=""
        try{
            def client = new SOAPClient(grailsApplication.config.crawler.webserviceURL)
            def response = client.send{
                body {
                    stopCrawler('xmlns':'http://crawlerws.pfc.ratzia.com/') {
                        sessionId(crawlerSessionInstance.id)
                    }
                }
            }
            stopCrawlerResponse = response.stopCrawlerResponse
            
            //CrawlerStatusUpdaterJob.schedule(new Date(),[:])
        }catch(Exception e){

        }
        
        redirect(action: "show", id: crawlerSessionInstance.id)
        //respond crawlerSessionInstance, view:'show'
    }
    
    @Transactional(rollbackFor = java.net.ConnectException.class)
    def resume(CrawlerSession crawlerSessionInstance) {
        crawlerSessionInstance.running = true
        crawlerSessionInstance.status = "running"
        crawlerSessionInstance.save flush:true
        
        //Start crawler
        def client = new SOAPClient(grailsApplication.config.crawler.webserviceURL)
        def response = client.send{
            body {
                startCrawler('xmlns':'http://crawlerws.pfc.ratzia.com/') {
                    sessionId(crawlerSessionInstance.id)
                    jail(crawlerSessionInstance.jail)
                    numCrawlers(crawlerSessionInstance.numCrawlers)
                    depth(crawlerSessionInstance.depth)
                    seed(crawlerSessionInstance.seed)
                }
            }
        }
        redirect(action: "show", id: crawlerSessionInstance.id)
        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'crawlerSessionInstance.label', default: 'CrawlerSession'), crawlerSessionInstance.id])
                redirect crawlerSessionInstance
            }
            '*' { respond crawlerSessionInstance, [status: OK] }
        }
        respond crawlerSessionInstance, view:'show'*/
    }

    def create() {
        respond new CrawlerSession(params)
    }

    @Transactional(rollbackFor = java.net.ConnectException.class)
    def save(CrawlerSession crawlerSessionInstance) {
        if (crawlerSessionInstance == null) {
            notFound()
            return
        }

        if (crawlerSessionInstance.hasErrors()) {
            respond crawlerSessionInstance.errors, view:'create'
            return
        }
        //Test jail regexp
        Pattern.compile(crawlerSessionInstance.jail);
        
        crawlerSessionInstance.save flush:true
        
        //Start crawler
        def client = new SOAPClient(grailsApplication.config.crawler.webserviceURL)
        def response = client.send{
            body {
                startCrawler('xmlns':'http://crawlerws.pfc.ratzia.com/') {
                    sessionId(crawlerSessionInstance.id)
                    jail(crawlerSessionInstance.jail)
                    numCrawlers(crawlerSessionInstance.numCrawlers)
                    depth(crawlerSessionInstance.depth)
                    seed(crawlerSessionInstance.seed)
                }
            }
        }
        
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'crawlerSessionInstance.label', default: 'CrawlerSession'), crawlerSessionInstance.id])
                redirect crawlerSessionInstance
            }
            '*' { respond crawlerSessionInstance, [status: CREATED] }
        }
    }

    /*def edit(CrawlerSession crawlerSessionInstance) {
        respond crawlerSessionInstance
    }

    @Transactional
    def update(CrawlerSession crawlerSessionInstance) {
        if (crawlerSessionInstance == null) {
            notFound()
            return
        }

        if (crawlerSessionInstance.hasErrors()) {
            respond crawlerSessionInstance.errors, view:'edit'
            return
        }
        //TODO: Missatge
        flash.message = "No es permet modificar sessions"//message(code: 'default.created.message', args: [message(code: 'crawlerSessionInstance.label', default: 'CrawlerSession'), crawlerSessionInstance.id])
        respond crawlerSessionInstance, view:'show'
        return
        crawlerSessionInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CrawlerSession.label', default: 'CrawlerSession'), crawlerSessionInstance.id])
                redirect crawlerSessionInstance
            }
            '*'{ respond crawlerSessionInstance, [status: OK] }
        }
    }*/

    @Transactional(rollbackFor = java.net.ConnectException.class)
    def delete(CrawlerSession crawlerSessionInstance) {

        if (crawlerSessionInstance == null) {
            notFound()
            return
        }

        //Delete session in crawler (it also stops crawler if running)
        def client = new SOAPClient(grailsApplication.config.crawler.webserviceURL)
        def response = client.send{
            body {
                deleteSession('xmlns':'http://crawlerws.pfc.ratzia.com/') {
                    sessionId(crawlerSessionInstance.id)
                }
            }
        }
        
        crawlerSessionInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CrawlerSession.label', default: 'CrawlerSession'), crawlerSessionInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'crawlerSessionInstance.label', default: 'CrawlerSession'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
