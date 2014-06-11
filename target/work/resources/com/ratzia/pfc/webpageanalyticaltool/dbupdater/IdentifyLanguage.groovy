package com.ratzia.pfc.webpageanalyticaltool.dbupdater

/**
 *
 * @author frans
 */
import com.carrotsearch.labs.langid.DetectedLanguage
import com.carrotsearch.labs.langid.LangIdV3
import org.jsoup.Jsoup;

import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
public class IdentifyLanguage extends SysPlugin {
    LangIdV3 langid;
    public IdentifyLanguage(){
        langid = new LangIdV3();
    }
    
    public void run(DBObject obj){
        LangIdV3 langid = new LangIdV3();
        DetectedLanguage result = langid.classify(Jsoup.parse(obj.get("html")).text(), true);
        obj.put("p_langcode", result.langCode); 
        obj.put("p_langconf", result.confidence); 
    }
}
