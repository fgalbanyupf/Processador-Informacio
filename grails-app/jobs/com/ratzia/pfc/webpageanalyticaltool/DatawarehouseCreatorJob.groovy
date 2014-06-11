/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ratzia.pfc.webpageanalyticaltool

import com.ratzia.pfc.webpageanalyticaltool.dbupdater.DatawarehouseBuilder

/**
 *
 * @author frans
 */
class DatawarehouseCreatorJob {
    def concurrent = false
    def grailsApplication
    static triggers = {
        cron name: 'atNight', cronExpression: "0 0 1 * * ?"
    }	
    
    def execute() {
        //TODO: Pendent validar camps parcialment actualitzats!
        BackgroundProcess backgroundProcess = BackgroundProcess.findByBackgroundProcessType(BackgroundProcessType.DATAWAREHOUSE_CREATOR)
        //As it is not concurrent we don't need to check against RUNNING, in case something crashed it would continue and would not get locked
        if(backgroundProcess.status != BackgroundProcessStatus.STOPPED){
            println "Datawarehouse Creator started"
            backgroundProcess.status = BackgroundProcessStatus.RUNNING
            backgroundProcess.save(flush: true)

            DatawarehouseBuilder dh = new DatawarehouseBuilder();
            dh.setFields((DBField[])DBField.findAll());
            dh.setDbURL(grailsApplication.config.bisystem.mysqldb.connectionString);
            dh.setDbUser(grailsApplication.config.bisystem.mysqldb.username);
            dh.setDbPass(grailsApplication.config.bisystem.mysqldb.password);
            dh.dropTables();
            dh.createTables();
            dh.createContent(grailsApplication.config.dbupdater.mongodb.serverAddress,grailsApplication.config.dbupdater.mongodb.db,grailsApplication.config.dbupdater.mongodb.collection);        

            //Regain the object
            backgroundProcess = BackgroundProcess.findByBackgroundProcessType(BackgroundProcessType.DATAWAREHOUSE_CREATOR)
            //backgroundProcess.status = BackgroundProcessStatus.IDLE
            //Manually fired only
            backgroundProcess.status = BackgroundProcessStatus.STOPPED
            
            backgroundProcess.save()
            println "Datawarehouse Creator finished"
        }
    }
}

