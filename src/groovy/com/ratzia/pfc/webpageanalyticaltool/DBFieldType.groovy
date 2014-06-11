package com.ratzia.pfc.webpageanalyticaltool

/**
 *
 * @author frans
 */
public enum  DBFieldType {
    NUMBER('number', 'INT', 20),
    VARCHAR('varchar', 'VARCHAR(255)', 255),
    DECIMAL('decimal','DECIMAL(20,10)', 20),
    DATE('date', 'DATETIME',20),       
    String id
    String sqlValue
    int maxLength
    DBFieldType(String id, String sqlValue, int maxLength) {
        this.id = id
        this.sqlValue = sqlValue
        this.maxLength = maxLength
    }	
    public String toString() { return sqlValue }
    public String sqlValue() { return sqlValue }
    public int maxLength(){ return maxLength }
    
}

