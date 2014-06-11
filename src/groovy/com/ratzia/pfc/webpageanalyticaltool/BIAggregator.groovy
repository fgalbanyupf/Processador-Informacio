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
public enum  BIAggregator {
    SUM('sum'),
    COUNT('count'),
    MIN('min'),
    MAX('max'),
    AVG('avg'),        
    DISTINCT_COUNT('distinct-count'),
    String id
    BIAggregator(String id) {
        this.id = id
    }	
    public String toString() { return id }   
}
