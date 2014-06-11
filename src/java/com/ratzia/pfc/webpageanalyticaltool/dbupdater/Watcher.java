/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ratzia.pfc.webpageanalyticaltool.dbupdater;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import groovy.lang.GroovyClassLoader;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.groovy.control.CompilationFailedException;

public class Watcher {
    static final String PLUGIN_VERSION_FIELD = "plugin_ver";
    private String serverAddress;
    private String db;
    private String collection;
    public Watcher(String serverAddress,String db,String collection){
        this.serverAddress = serverAddress;
        this.db = db;
        this.collection = collection;
    }   
    
    public void processDatabase(LinkedList<String> pluginsCode, String currentVersion) throws UnknownHostException {
        /**** Plugins ****/
        LinkedList<SysPlugin> plugins = loadPlugins(pluginsCode);
        /*****************/
        
        /*SecurityManager oldSecurityManager = System.getSecurityManager();
        DBPluginSecurityManager dbPluginSecurityManager = new DBPluginSecurityManager();
        System.setSecurityManager(dbPluginSecurityManager);
        //Will open the security manager so we need to ensure it is closed afterwards
        try{*/
        MongoClient mongoClient = new MongoClient(serverAddress);
        DB local = mongoClient.getDB(db);
        DBCollection dbCol = local.getCollection(collection);
        BasicDBObject query = new BasicDBObject();
        query.put(PLUGIN_VERSION_FIELD, new BasicDBObject("$ne", currentVersion));
        DBCursor cursor = dbCol.find(query);
        long count = 0;
        while (cursor.hasNext()) {
            DBObject obj = cursor.next();

            //Copy contents
            BasicDBObject res = new BasicDBObject();
            for(String k:obj.keySet()){
                res.put(k, obj.get(k));
            }

            //Plugin operations
            for (SysPlugin plugin : plugins) {
                try{
                    plugin.run(res);
                }catch(Exception ex){
                    System.out.println("Error en " + plugin.getClass());
                    Logger.getLogger(Watcher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            //Put plugin only fields into the original object
            for(String k:res.keySet()){
                if((k.substring(0, 2)).compareTo("p_") == 0){
                    obj.put(k,res.get(k));
                }
            }

            //Update version on object
            obj.put(PLUGIN_VERSION_FIELD,currentVersion);

            dbCol.save(obj);
            count++;
        }
        cursor.close();

        if(count > 0){
            System.out.println(count + " updated");
        }
            
        /*}catch(Exception ex){
            Logger.getLogger(Watcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        //close sandbox
        System.setSecurityManager(oldSecurityManager);*/
        
        
    }
    
    public LinkedList<SysPlugin> loadPlugins(LinkedList<String> pluginsCode) {
        LinkedList<SysPlugin> plugins = new LinkedList<SysPlugin>();
        for (String pluginCode : pluginsCode) {
            //Script loading
            GroovyClassLoader gcl = new GroovyClassLoader();
            Class clazz = gcl.parseClass(pluginCode);
            Object aScript;
            try {
                aScript = clazz.newInstance();
                SysPlugin plugin = (SysPlugin) aScript;
                plugins.add(plugin);
            } catch (InstantiationException ex) {
                Logger.getLogger(Watcher.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Watcher.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CompilationFailedException ex){
                Logger.getLogger(Watcher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return plugins;
    }
    
    
    /*public LinkedList<SysPlugin> loadPlugins() throws IOException{
        LinkedList<SysPlugin> plugins = new LinkedList<SysPlugin>();
        File dir = new File(PLUGINS_FLDR);
        File [] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".groovy");
            }
        });

        for (File pluginFile : files) {
            //Script loading
            GroovyClassLoader gcl = new GroovyClassLoader();
            Class clazz = gcl.parseClass(pluginFile);
            Object aScript;
            try {
                aScript = clazz.newInstance();
                SysPlugin plugin = (SysPlugin) aScript;
                if(plugins.contains(plugin) == false){
                    plugins.add(plugin);
                    System.out.println(plugin.getClass() + " loaded");
                }else{
                    System.out.println(plugin.getClass() + " skipped, already in");
                } 
            } catch (InstantiationException ex) {
                Logger.getLogger(Watcher.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Watcher.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CompilationFailedException ex){
                Logger.getLogger(Watcher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //This is involved in plugin unique combination version/ID
        Collections.sort(plugins);
        return plugins;
    }*/
}