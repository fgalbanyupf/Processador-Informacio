/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ratzia.pfc.webpageanalyticaltool

/**
 *
 * @author frans
 */
public enum BackgroundProcessType {
    DATAWAREHOUSE_CREATOR('dw_creator'),
    CRAWLERDB_EXPANDER('cdb_expander'),
    CRAWLERSTATUS_UPDATER('cs_updater'),
    String id
    BackgroundProcessType(String id) {
        this.id = id
    }	
    static BackgroundProcessType valueOfId( String id ) {
        values().find { it.id == id }
    }
    public String toString() { return id }   
}


