/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ratzia.pfc.webpageanalyticaltool.dbupdater;

/**
 *
 * @author frans
 */



/*
Millora OBLIGADA!!
* SEGURETAT: Executar dins de Sandbox

MILLORES possibles:
* Vincular els camps amb el que informem al sistema per a poder comprovar que no es retorna cap camp diferent,
  hores d'ara el fet d'informar els camps bé i tractar-los de manera correcta es basa en la confiança.
* Sistema de dependències, per a crear plugins que deriven o fan servir càlculs d'altres
*/

import com.mongodb.DBObject;
public abstract class SysPlugin {
    
    /*public abstract String getID();
    public abstract String getVersion();*/
    
    public abstract void run(DBObject obj);
    
    
    /*public String getIDAndVersion(){
    	return getID() + "-" + getVersion();
    }
    
    public int compareTo(SysPlugin obj){
        return this.getIDAndVersion().compareTo(obj.getIDAndVersion());
    }*/
    
    /*public boolean equals(SysPlugin o){
        return this.getIDAndVersion().compareTo(o.getIDAndVersion()) == 0;
    }*/
    
    /*@Override
    public int hashCode(){
        return this.getIDAndVersion().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            return false;
        }
        if (obj instanceof SysPlugin) {
            return (this.getIDAndVersion().compareTo(((SysPlugin)obj).getIDAndVersion()) == 0);
        }else{
            return false;
        }
        
    }*/
}
