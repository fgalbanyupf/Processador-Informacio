package com.ratzia.pfc.webpageanalyticaltool

class CrawlerSession {

    static constraints = {
        seed(nullable:false,maxSize:100,url:true)
        numCrawlers(nullable:false)
        depth(nullable:false)
        status(blank:true,nullable:true)
    }
    String jail="https?://www.example.com.*"
    String status=""
    int numCrawlers=1
    int depth=4
    String seed
    boolean running=true
    
    Date dateCreated
    Date lastUpdated
    String toString(){
        if(jail!=""){
            return seed + " - " + jail
        }else{
            return seed
        }        
    }
}
