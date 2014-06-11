/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ratzia.pfc.webpageanalyticaltool.dbupdater;

/**
 *
 * @author frans
 */
import java.sql.*;
import groovy.sql.Sql;
import com.ratzia.pfc.webpageanalyticaltool.DBField;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
public class DatawarehouseBuilder {

    private String jdbcDriver = "com.mysql.jdbc.Driver";
    private String dbURL;
    private String dbUser;
    private String dbPass;
    
    private DBField[] fields;

    public boolean createTables() {
        def driver = Class.forName(jdbcDriver).newInstance();
        Properties properties = new Properties();
        properties.put("user",dbUser)
        properties.put("password", dbPass)
        Connection connection = driver.connect(dbURL, properties);
        Sql sqlInstance = new Sql(connection);
        //Base page table
        sqlInstance.execute("CREATE TABLE page (id INTEGER not NULL AUTO_INCREMENT, PRIMARY KEY ( id ))")
        
        //Fields per page
        String sql = "CREATE TABLE page_fields (id INTEGER not NULL, "

        for(DBField field in fields){
            if(!field.isCollection){
                sql += " " + field.sqlStatement() + ", "
            }
        }                
        sql+= " PRIMARY KEY ( id ), FOREIGN KEY (id) REFERENCES page(id) ON DELETE CASCADE)";
        sqlInstance.execute(sql)

        
        //Tables for collection fields
        for(DBField field in fields){
            if(field.isCollection){
                String sqlC = "CREATE TABLE " + field.fieldName + "_table (id INTEGER not NULL,  " + field.sqlStatement() + ", FOREIGN KEY (id) REFERENCES page(id) ON DELETE CASCADE)"; 
                sqlInstance.execute(sqlC)
            }
        }
        
        sqlInstance.execute("CREATE TABLE country (code VARCHAR(2) not NULL,name VARCHAR(100) not NULL)")
        //sqlInstance.execute("CREATE TABLE domain (domain VARCHAR(100) not NULL, PRIMARY KEY ( domain ))")
        
        //CREATE TABLE domain (domain VARCHAR(100) not NULL, p_server_country, VARCHAR(100) PRIMARY KEY ( domain ))
        
        return true;
    }
    
    public boolean dropTables() {
        def driver = Class.forName(jdbcDriver).newInstance();
        Properties properties = new Properties();
        properties.put("user",dbUser)
        properties.put("password", dbPass)
        Connection connection = driver.connect(dbURL, properties);
        Sql sqlInstance = new Sql(connection);
        
        for(DBField field in fields){
            if(field.isCollection){
                sqlInstance.execute( "DROP TABLE IF EXISTS " + field.fieldName + "_table ")
            }
        }
        sqlInstance.execute( "DROP TABLE IF EXISTS page_fields ")
        sqlInstance.execute( "DROP TABLE IF EXISTS page ")
        sqlInstance.execute( "DROP TABLE IF EXISTS country ")
        //sqlInstance.execute( "DROP TABLE IF EXISTS domain ")
        
        return true;
    }
    
    
    public void createContent(String serverAddress,String db,String collection){
        def driver = Class.forName(jdbcDriver).newInstance();
        Properties properties = new Properties();
        properties.put("user",dbUser)
        properties.put("password", dbPass)
        Connection connection = driver.connect(dbURL, properties);
        Sql sqlInstance = new Sql(connection);
        
        //Prefill countries table
        def countriesISOA2 = ["AF":"Afghanistan","AX":"Ã…land Islands","AL":"Albania","DZ":"Algeria","AS":"American Samoa","AD":"Andorra","AO":"Angola","AI":"Anguilla","AQ":"Antarctica","AG":"Antigua And Barbuda","AR":"Argentina","AM":"Armenia","AW":"Aruba","AU":"Australia","AT":"Austria","AZ":"Azerbaijan","BS":"Bahamas","BH":"Bahrain","BD":"Bangladesh","BB":"Barbados","BY":"Belarus","BE":"Belgium","BZ":"Belize","BJ":"Benin","BM":"Bermuda","BT":"Bhutan","BO":"Bolivia, Plurinational State Of","BQ":"Bonaire, Sint Eustatius And Saba","BA":"Bosnia And Herzegovina","BW":"Botswana","BV":"Bouvet Island","BR":"Brazil","IO":"British Indian Ocean Territory","BN":"Brunei Darussalam","BG":"Bulgaria","BF":"Burkina Faso","BI":"Burundi","KH":"Cambodia","CM":"Cameroon","CA":"Canada","CV":"Cape Verde","KY":"Cayman Islands","CF":"Central African Republic","TD":"Chad","CL":"Chile","CN":"China","CX":"Christmas Island","CC":"Cocos (keeling) Islands","CO":"Colombia","KM":"Comoros","CG":"Congo","CD":"Congo, The Democratic Republic Of The","CK":"Cook Islands","CR":"Costa Rica","CI":"CÃ´te D'ivoire","HR":"Croatia","CU":"Cuba","CW":"CuraÃ§ao","CY":"Cyprus","CZ":"Czech Republic","DK":"Denmark","DJ":"Djibouti","DM":"Dominica","DO":"Dominican Republic","EC":"Ecuador","EG":"Egypt","SV":"El Salvador","GQ":"Equatorial Guinea","ER":"Eritrea","EE":"Estonia","ET":"Ethiopia","FK":"Falkland Islands (malvinas)","FO":"Faroe Islands","FJ":"Fiji","FI":"Finland","FR":"France","GF":"French Guiana","PF":"French Polynesia","TF":"French Southern Territories","GA":"Gabon","GM":"Gambia","GE":"Georgia","DE":"Germany","GH":"Ghana","GI":"Gibraltar","GR":"Greece","GL":"Greenland","GD":"Grenada","GP":"Guadeloupe","GU":"Guam","GT":"Guatemala","GG":"Guernsey","GN":"Guinea","GW":"Guinea-bissau","GY":"Guyana","HT":"Haiti","HM":"Heard Island And Mcdonald Islands","VA":"Holy See (vatican City State)","HN":"Honduras","HK":"Hong Kong","HU":"Hungary","IS":"Iceland","IN":"India","ID":"Indonesia","IR":"Iran, Islamic Republic Of","IQ":"Iraq","IE":"Ireland","IM":"Isle Of Man","IL":"Israel","IT":"Italy","JM":"Jamaica","JP":"Japan","JE":"Jersey","JO":"Jordan","KZ":"Kazakhstan","KE":"Kenya","KI":"Kiribati","KP":"Korea, Democratic People's Republic Of","KR":"Korea, Republic Of","KW":"Kuwait","KG":"Kyrgyzstan","LA":"Lao People's Democratic Republic","LV":"Latvia","LB":"Lebanon","LS":"Lesotho","LR":"Liberia","LY":"Libya","LI":"Liechtenstein","LT":"Lithuania","LU":"Luxembourg","MO":"Macao","MK":"Macedonia, The Former Yugoslav Republic Of","MG":"Madagascar","MW":"Malawi","MY":"Malaysia","MV":"Maldives","ML":"Mali","MT":"Malta","MH":"Marshall Islands","MQ":"Martinique","MR":"Mauritania","MU":"Mauritius","YT":"Mayotte","MX":"Mexico","FM":"Micronesia, Federated States Of","MD":"Moldova, Republic Of","MC":"Monaco","MN":"Mongolia","ME":"Montenegro","MS":"Montserrat","MA":"Morocco","MZ":"Mozambique","MM":"Myanmar","NA":"Namibia","NR":"Nauru","NP":"Nepal","NL":"Netherlands","NC":"New Caledonia","NZ":"New Zealand","NI":"Nicaragua","NE":"Niger","NG":"Nigeria","NU":"Niue","NF":"Norfolk Island","MP":"Northern Mariana Islands","NO":"Norway","OM":"Oman","PK":"Pakistan","PW":"Palau","PS":"Palestinian Territory, Occupied","PA":"Panama","PG":"Papua New Guinea","PY":"Paraguay","PE":"Peru","PH":"Philippines","PN":"Pitcairn","PL":"Poland","PT":"Portugal","PR":"Puerto Rico","QA":"Qatar","RE":"RÃ©union","RO":"Romania","RU":"Russian Federation","RW":"Rwanda","BL":"Saint BarthÃ©lemy","SH":"Saint Helena, Ascension And Tristan Da Cunha","KN":"Saint Kitts And Nevis","LC":"Saint Lucia","MF":"Saint Martin (french Part)","PM":"Saint Pierre And Miquelon","VC":"Saint Vincent And The Grenadines","WS":"Samoa","SM":"San Marino","ST":"Sao Tome And Principe","SA":"Saudi Arabia","SN":"Senegal","RS":"Serbia","SC":"Seychelles","SL":"Sierra Leone","SG":"Singapore","SX":"Sint Maarten (dutch Part)","SK":"Slovakia","SI":"Slovenia","SB":"Solomon Islands","SO":"Somalia","ZA":"South Africa","GS":"South Georgia And The South Sandwich Islands","SS":"South Sudan","ES":"Spain","LK":"Sri Lanka","SD":"Sudan","SR":"Suriname","SJ":"Svalbard And Jan Mayen","SZ":"Swaziland","SE":"Sweden","CH":"Switzerland","SY":"Syrian Arab Republic","TW":"Taiwan, Province Of China","TJ":"Tajikistan","TZ":"Tanzania, United Republic Of","TH":"Thailand","TL":"Timor-leste","TG":"Togo","TK":"Tokelau","TO":"Tonga","TT":"Trinidad And Tobago","TN":"Tunisia","TR":"Turkey","TM":"Turkmenistan","TC":"Turks And Caicos Islands","TV":"Tuvalu","UG":"Uganda","UA":"Ukraine","AE":"United Arab Emirates","GB":"United Kingdom","US":"United States","UM":"United States Minor Outlying Islands","UY":"Uruguay","UZ":"Uzbekistan","VU":"Vanuatu","VE":"Venezuela, Bolivarian Republic Of","VN":"Viet Nam","VG":"Virgin Islands, British","VI":"Virgin Islands, U.s.","WF":"Wallis And Futuna","EH":"Western Sahara","YE":"Yemen","ZM":"Zambia","ZW":"Zimbabwe"]
        def insertSqlCountries = "INSERT INTO country (code,name) VALUES(?,?)"
        countriesISOA2.each{ code, name ->
            sqlInstance.executeInsert( insertSqlCountries, [code,name])
        }
        
        //Main table insert statement
        String sqlInsert = "INSERT INTO page_fields (id, "
        String sqlInsertValues = "(?,"
        for(DBField field in fields){
            if(!field.isCollection){
                sqlInsert += " " + field.fieldName + ","
                sqlInsertValues += " ?,"
            }
        }   
        //Remove trailing comma
        sqlInsert = sqlInsert[0..-2]
        sqlInsertValues = sqlInsertValues[0..-2]
        sqlInsert += ") VALUES " + sqlInsertValues + ")"
        
        //Collection fields insert statements
        def collectionFieldsInsert = [:]
        for(DBField field in fields){
            if(field.isCollection){
                collectionFieldsInsert[field.fieldName] = "INSERT INTO " + field.fieldName + "_table (id," + field.fieldName + ") VALUES(?,?)"
            }
        }
        
        
        
        MongoClient mongoClient = new MongoClient(serverAddress);
        DB local = mongoClient.getDB(db);
        DBCollection dbCol = local.getCollection(collection);

        DBCursor cursor = dbCol.find();
        while (cursor.hasNext()) {
            DBObject obj = cursor.next();
            //Base page insert
            def lastId = sqlInstance.executeInsert( "INSERT INTO page (id) VALUES (0)")[0][0]
            //Page fields...
            def values = [lastId]
            for(DBField field in fields){
                if(!field.isCollection){
                    def value = obj.get(field.fieldName)
                    //Try to truncate fields that are too long
                    try{
                        int maxLength = (value.length() < field.fieldType.maxLength())?value.length():field.fieldType.maxLength();
                        value = value.substring(0, maxLength)
                    }catch(Exception e){}
                    values << value
                }
            }   
            sqlInstance.executeInsert( sqlInsert, values)
            
            for(DBField field in fields){
                if(field.isCollection){
                    for(element in obj.get(field.fieldName)){
                        sqlInstance.executeInsert( collectionFieldsInsert[field.fieldName], [lastId,element])
                    }
                }
            }
        }
        cursor.close();
        //We create an index, domain field is mandatory
        sqlInstance.execute("CREATE INDEX id_domain USING BTREE ON page_fields (domain)")
        //sqlInstance.execute("CREATE INDEX id_p_server_country USING BTREE ON page_fields (p_server_country)")
        //sqlInstance.execute("CREATE INDEX id_p_langcode USING BTREE ON page_fields (p_langcode)")
        //sqlInstance.execute("INSERT INTO domain SELECT DISTINCT domain FROM page_fields ")
        
    }
    
    /*** Getters / Setters ***/
    public DBField[] getFields() {
        return fields;
    }

    public void setFields(DBField[] fields) {
        this.fields = fields;
    }
    
    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public String getDbURL() {
        return dbURL;
    }

    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPass() {
        return dbPass;
    }

    public void setDbPass(String dbPass) {
        this.dbPass = dbPass;
    }
}


