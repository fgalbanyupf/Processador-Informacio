package com.ratzia.pfc.webpageanalyticaltool

class BIMeasure {

    static constraints = {
        name(nullable:false,unique: true, maxSize:50)
        aggregator(nullable:false)
        field(nullable:false)
    }
    String name
    BIAggregator aggregator
    DBField field
    Boolean visible=true
    
    String toString(){
        return name
    }
}
