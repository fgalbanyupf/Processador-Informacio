package com.ratzia.pfc.webpageanalyticaltool
import com.ratzia.pfc.webpageanalyticaltool.dbupdater.Watcher;
class DatabaseFeedExtraFieldsJob {
    def concurrent = false
    def grailsApplication
    static triggers = {
      simple repeatInterval: 600000l // 10 min.
      //simple repeatInterval: 15000000000l // 15 s.
    }

    def execute() {
        def config
        if(new File(grailsApplication.config.dbupdater.jobconfigfile).exists()){
            config = new ConfigSlurper().parse(new File(grailsApplication.config.dbupdater.jobconfigfile).toURL())
        }else{
            config = new ConfigSlurper().parse("lastVersion = 0\nlastVersionString=\"no\"")
        }
        
        //Enabled plugins
        LinkedList<String> pluginsCode = new LinkedList<String>();
        def plugins = DBPlugin.findAllByEnabled(true, [sort: "name", order: "desc"])
        String versionString = ""
        for(DBPlugin plugin in plugins){
            pluginsCode.add(plugin.code)   
            versionString+=plugin.toString()
        }
        
        //Check changes
        if(config.lastVersionString != versionString){
            config.lastVersionString = versionString
            config.lastVersion++
            print "Plugin changes detected"
        }else{
            print "No plugin changes detected"
        }
        long currentVersion = config.lastVersion
        
        BackgroundProcess backgroundProcess = BackgroundProcess.findByBackgroundProcessType(BackgroundProcessType.CRAWLERDB_EXPANDER)
        if(backgroundProcess.status != BackgroundProcessStatus.STOPPED){
            backgroundProcess.status = BackgroundProcessStatus.RUNNING
            backgroundProcess.save(flush: true)

            //Execute watcher
            Watcher w = new Watcher(grailsApplication.config.dbupdater.mongodb.serverAddress,\
                                    grailsApplication.config.dbupdater.mongodb.db,\
                                    grailsApplication.config.dbupdater.mongodb.collection);
            w.processDatabase(pluginsCode, String.valueOf(currentVersion))

            //Regain the object
            backgroundProcess = BackgroundProcess.findByBackgroundProcessType(BackgroundProcessType.CRAWLERDB_EXPANDER)
            backgroundProcess.status = BackgroundProcessStatus.IDLE
            backgroundProcess.save()

            //Update config file with last version
            new File(grailsApplication.config.dbupdater.jobconfigfile).withWriter { writer ->
                 config.writeTo(writer)
            }
        }
    }
}
