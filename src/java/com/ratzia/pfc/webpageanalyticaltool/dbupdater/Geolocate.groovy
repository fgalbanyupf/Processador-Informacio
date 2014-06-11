            
package com.ratzia.pfc.webpageanalyticaltool.dbupdater

/**
 *
 * @author ...
 */
 
import java.net.InetAddress;

import com.mongodb.DBObject;
public class Geolocate extends SysPlugin {
    def database = []
    def domains = [:] //domains cache
    //Constructor per defecte
    public Geolocate(){
        def databaseFile = new File('/Users/frans/Desktop/ip_database.csv')
        databaseFile.eachLine {
            def line = it.replaceAll('"','')
            database << line.tokenize(',')
        }
    }
    
    public String countryforIP(String ip){
        for(e in database){
            if(ip < e[1]){
                if(ip > e[0]){
                    return e[2]
                }
            }
        }
        return "not-found"
    }

    //Mètode cridat per cada registre
    public void run(DBObject obj){
        if(domains[obj.get("domain")]){
            obj.put("p_ip", domains[obj.get("domain")][0] );
            obj.put("p_server_country", domains[obj.get("domain")][1]);
        }else{
            def ipAddress
            if((obj.get("p_ip") != "") && (obj.get("p_ip"))){
                ipAddress = obj.get("p_ip")   
            }else{
                InetAddress address = java.net.InetAddress.getByName(obj.get("domain"));
                ipAddress = address.getHostAddress()        
                obj.put("p_ip", ipAddress )
            }
            def country = countryforIP(ipAddress)
            obj.put("p_server_country", country);
            domains[obj.get("domain")]=[ipAddress,country]
        }
        
    }
}

        