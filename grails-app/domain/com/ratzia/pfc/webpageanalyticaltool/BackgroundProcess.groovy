package com.ratzia.pfc.webpageanalyticaltool

class BackgroundProcess {

    static constraints = {
        name(nullable:false,unique: true, maxSize:50)
        backgroundProcessType(nullable:false,unique: true)
        
    }
    
    BackgroundProcessType backgroundProcessType
    String name
    BackgroundProcessStatus status
    float progress=0

    String toString(){
        return name
    }
}
