package com.ratzia.pfc.webpageanalyticaltool
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_FULLY'])
class SystemStatusController {

    def index() { }
    
    def processesStatus(){
        def backgroundProcesses = []
        def crawlerSessions = []
        BackgroundProcess.findAll().each{
            backgroundProcesses << [it.name,it.status.toString(), it.backgroundProcessType.id]
        }
        
        CrawlerSession.findAllRunning().each{
            crawlerSessions << [it.id, it.seed]
        }
        def result = [backgroundProcesses:backgroundProcesses, crawlerSessions:crawlerSessions]
        render result as JSON
    }
    
    def startProcess(params){
        BackgroundProcessType backgroundProcessType = BackgroundProcessType.valueOfId(params.id)
        BackgroundProcess backgroundProcess = BackgroundProcess.findByBackgroundProcessType(backgroundProcessType)
        if(backgroundProcess.status == BackgroundProcessStatus.STOPPED){
            backgroundProcess.status = BackgroundProcessStatus.IDLE //eq idle
            backgroundProcess.save(true)
            println "Starting " + backgroundProcess
        }
        render backgroundProcess as JSON
    }
    
    def stopProcess(params){
        BackgroundProcessType backgroundProcessType = BackgroundProcessType.valueOfId(params.id)
        BackgroundProcess backgroundProcess = BackgroundProcess.findByBackgroundProcessType(backgroundProcessType)
        if(backgroundProcess.status == BackgroundProcessStatus.IDLE){
            backgroundProcess.status = BackgroundProcessStatus.STOPPED
            backgroundProcess.save(true)
            println "Stopping " + backgroundProcess
        }
        render backgroundProcess as JSON
    }
    
    def launchExpander() {
        DatabaseFeedExtraFieldsJob.schedule(new Date(),[:])
        def targetUri = params.targetUri ?: "/"
        redirect(uri: targetUri)
        /*def text = [ok:'OK']
        render text as JSON*/
    }
}
