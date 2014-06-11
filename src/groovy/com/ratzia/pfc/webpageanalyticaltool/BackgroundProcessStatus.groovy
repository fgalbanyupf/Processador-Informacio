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
public enum BackgroundProcessStatus {
    STOPPED('stopped'),
    RUNNING('running'),
    IDLE('idle'),
    CANCELED('canceled'),
    String id
    BackgroundProcessStatus(String id) {
        this.id = id
    }	
    public String toString() { return id }   
}

