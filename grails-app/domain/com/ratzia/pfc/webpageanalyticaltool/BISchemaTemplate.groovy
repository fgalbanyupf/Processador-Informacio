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
class BISchemaTemplate {
    static constraints = {
        name(nullable:false,unique: true, maxSize:50)
        code(nullable:false, blank:false, maxSize:50000)
        generatedCode(nullable:true, blank:true, maxSize:50000)
    }
    static mapping = {
        code type: 'text'
        generatedCode type: 'text'
    }
    
    String name
    String code

    String generatedCode
    boolean enabled=false
    
    String toString(){
        return name
    }
}

