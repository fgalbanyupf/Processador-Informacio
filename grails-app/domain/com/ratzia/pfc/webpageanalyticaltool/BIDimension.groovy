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
class BIDimension {
    static constraints = {
        name(nullable:false,unique: true, maxSize:50)
        fields(nullable:true)
    }
    static mapping = {
    }
    List fields
    static hasMany = [ fields : DBField]
    
    String name
    String toString(){
        return name
    }
    
    void fieldUp(DBField field){
        def index = fields.indexOf(field)
        if(index > 0){
            def elemT = fields[index-1];
            def elemP = fields[index];
            fields.putAt([index-1],elemP);
            fields.putAt([index],elemT);        
        }
    }

    void fieldDown(DBField field){
        def index = fields.indexOf(field)
        if(( index >=0) && (index < ( fields.size()-1))){
            def elemT = fields[index+1];
            def elemP = fields[index];
            fields.putAt([index+1],elemP);
            fields.putAt([index],elemT);        
        }
    }
    
}

