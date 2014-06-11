/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ratzia.pfc.webpageanalyticaltool

//import com.ratzia.pfc.webpageanalyticaltool.crawler.Crawler
import wslite.soap.*
/**
 *
 * @author frans
 */
class CrawlerStatusUpdaterJob {
    def grailsApplication
    static triggers = {
        simple repeatInterval: 30000l // 30 s.
    }

    def execute(context) {
        BackgroundProcess backgroundProcess = BackgroundProcess.findByBackgroundProcessType(BackgroundProcessType.CRAWLERSTATUS_UPDATER)
        if(backgroundProcess.status != BackgroundProcessStatus.STOPPED){
            println "CrawlerStatusUpdaterJob"
            backgroundProcess.status = BackgroundProcessStatus.RUNNING
            backgroundProcess.save(flush: true)
            for (CrawlerSession crawlerSession in CrawlerSession.findAllRunning()){
                try{
                    def client = new SOAPClient(grailsApplication.config.crawler.webserviceURL)
                    def response = client.send{
                        body {
                            crawlerStatus('xmlns':'http://crawlerws.pfc.ratzia.com/') {
                                sessionId(crawlerSession.id)
                            }
                        }
                    }
                    crawlerSession.status = response.crawlerStatusResponse
                    if((crawlerSession.status != "running") && (crawlerSession.status != "stopping")){
                        crawlerSession.running = false
                    }
                    crawlerSession.save()
                }catch(Exception e){
                }
            }

            //Regain the object
            backgroundProcess = BackgroundProcess.findByBackgroundProcessType(BackgroundProcessType.CRAWLERSTATUS_UPDATER)
            backgroundProcess.status = BackgroundProcessStatus.IDLE
            backgroundProcess.save()
        }
    }
}

