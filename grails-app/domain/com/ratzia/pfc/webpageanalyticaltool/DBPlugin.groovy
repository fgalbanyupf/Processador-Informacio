package com.ratzia.pfc.webpageanalyticaltool

class DBPlugin {
    static constraints = {
        name(nullable:false,unique: true, maxSize:50)
        code(nullable:false, blank:false, maxSize:50000)
        status(nullable:true, blank:true, maxSize:5000)
        fields(nullable:true)
    }
    static mapping = {
        code type: 'text'
        status type: 'text'
    }
    static hasMany = [ fields : DBField]
    
    String name
    String code
    
    String status
    boolean enabled=false
    
    String toString(){
        return name+ "-"+version
    }
}
