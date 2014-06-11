package com.ratzia.pfc.webpageanalyticaltool

class DBField {
    static constraints = {
        fieldName(nullable:false,unique: true, maxSize:50)
        plugin(nullable:true)
    }
    
    static belongsTo = [plugin:DBPlugin]
    
    DBFieldType fieldType
    String fieldName
    String descriptiveName
    boolean fieldNullable=true
    boolean isCollection=false
    
    Date dateCreated
    Date lastUpdated
    String toString(){
        if(isCollection){
            return descriptiveName + "*"
        }else{
            return descriptiveName
        }
    }
    
    Boolean isPluginField(){
        if(plugin){
            return true
        }else{
            return pluginField
        }
    }
    
    String sqlStatement(){
        def sql = ""
        if(fieldNullable){
            return fieldName + " " + fieldType.sqlValue()
        }else{
            return fieldName + " " + fieldType.sqlValue() + " NOT NULL"
        }
    }
}
