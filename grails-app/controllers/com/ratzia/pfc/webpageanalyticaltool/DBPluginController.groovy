package com.ratzia.pfc.webpageanalyticaltool


import com.ratzia.pfc.webpageanalyticaltool.dbupdater.DatawarehouseBuilder
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.exceptions.CompilationFailedException
import java.util.regex.*
import com.ratzia.pfc.webpageanalyticaltool.dbupdater.SysPlugin;

import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_FULLY'])
@Transactional(readOnly = true)
class DBPluginController {
    
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def grailsApplication
    
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond DBPlugin.list(params), model:[DBPluginInstanceCount: DBPlugin.count()]
    }

    def show(DBPlugin DBPluginInstance) {
        respond DBPluginInstance
    }

    def create() {
        respond new DBPlugin(params)
    }

    @Transactional
    def save(DBPlugin DBPluginInstance) {
        if (DBPluginInstance == null) {
            notFound()
            return
        }

        if (DBPluginInstance.hasErrors()) {
            respond DBPluginInstance.errors, view:'create'
            return
        }
        def result = testCode(DBPluginInstance)
        if(!result.result){
            DBPluginInstance.status = result.message
            DBPluginInstance.enabled = false
        }else{
            DBPluginInstance.status = null;
        }
        DBPluginInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'DBPluginInstance.label', default: 'DBPlugin'), DBPluginInstance.id])
                redirect DBPluginInstance
            }
            '*' { respond DBPluginInstance, [status: CREATED] }
        }
    }

    def edit(DBPlugin DBPluginInstance) {
        respond DBPluginInstance
    }

    @Transactional
    def update(DBPlugin DBPluginInstance) {
        if (DBPluginInstance == null) {
            notFound()
            return
        }

        if (DBPluginInstance.hasErrors()) {
            respond DBPluginInstance.errors, view:'edit'
            return
        }
        
        def result = testCode(DBPluginInstance)
        if(!result.result){
            DBPluginInstance.status = result.message
            DBPluginInstance.enabled = false
        }else{
            DBPluginInstance.status = null;
        }

        DBPluginInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'DBPlugin.label', default: 'DBPlugin'), DBPluginInstance.id])
                redirect DBPluginInstance
            }
            '*'{ respond DBPluginInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(DBPlugin DBPluginInstance) {

        if (DBPluginInstance == null) {
            notFound()
            return
        }

        DBPluginInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'DBPlugin.label', default: 'DBPlugin'), DBPluginInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    def testCode(DBPlugin DBPluginInstance){
        def message = ""
        try {
            GroovyClassLoader gcl = new GroovyClassLoader()
            Class clazz = gcl.parseClass(DBPluginInstance.code)
            Object aScript = clazz.newInstance()
            SysPlugin plugin = (SysPlugin) aScript
            return [result:true,message:message]
            
        } catch (InstantiationException ex) {
            message = ex.message
            //Logger.getLogger(Watcher.class.getName()).log(Level.SEVERE, null, ex)
        } catch (IllegalAccessException ex) {
            message = ex.message
            //Logger.getLogger(Watcher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CompilationFailedException ex){
            message = ex.message
            //Logger.getLogger(Watcher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex){
            message = ex.message
            //Logger.getLogger(Watcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        return [result:false,message:message]
    }
    
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'DBPluginInstance.label', default: 'DBPlugin'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
