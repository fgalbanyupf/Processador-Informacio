import com.ratzia.pfc.webpageanalyticaltool.DBField;
import com.ratzia.pfc.webpageanalyticaltool.DBFieldType;
import com.ratzia.pfc.webpageanalyticaltool.BackgroundProcess;
import com.ratzia.pfc.webpageanalyticaltool.BackgroundProcessType;
import com.ratzia.pfc.webpageanalyticaltool.BackgroundProcessStatus;
import com.ratzia.pfc.webpageanalyticaltool.SecRole;
import com.ratzia.pfc.webpageanalyticaltool.SecUser;
import com.ratzia.pfc.webpageanalyticaltool.SecUserSecRole;
class BootStrap {
    def springSecurityService
    def init = { servletContext ->
        //Standard fields
        DBField sessionId = new DBField(fieldName:"session_id",fieldType:DBFieldType.NUMBER,fieldNullable:true).save();
        DBField domain = new DBField(fieldName:"domain",fieldType:DBFieldType.VARCHAR,fieldNullable:false).save();
        DBField url = new DBField(fieldName:"url",fieldType:DBFieldType.VARCHAR,fieldNullable:false).save();
        DBField parentUrl = new DBField(fieldName:"parentUrl",fieldType:DBFieldType.VARCHAR,fieldNullable:true).save();
        DBField charset = new DBField(fieldName:"charset",fieldType:DBFieldType.VARCHAR,fieldNullable:false).save();
        DBField dateAdd = new DBField(fieldName:"dateAdd",fieldType:DBFieldType.DATE,fieldNullable:false).save();
        
        //Background processes
        BackgroundProcess dbExpander = new BackgroundProcess(name:"DB Expander",backgroundProcessType:BackgroundProcessType.CRAWLERDB_EXPANDER, status: BackgroundProcessStatus.STOPPED).save();
        BackgroundProcess dwCreator = new BackgroundProcess(name:"Datawarehouse Creator",backgroundProcessType:BackgroundProcessType.DATAWAREHOUSE_CREATOR, status: BackgroundProcessStatus.STOPPED).save();
        BackgroundProcess crwlrStatusUpdater = new BackgroundProcess(name:"Crawler Status Updater",backgroundProcessType:BackgroundProcessType.CRAWLERSTATUS_UPDATER, status: BackgroundProcessStatus.STOPPED).save();
        
        //Security users
        def userRole = SecRole.findByAuthority('ROLE_USER') ?: new SecRole(authority: 'ROLE_USER').save(failOnError: true)
        def adminRole = SecRole.findByAuthority('ROLE_ADMIN') ?: new SecRole(authority: 'ROLE_ADMIN').save(failOnError: true)
        
        def adminUser = SecUser.findByUsername('admin') ?: new SecUser(
                username: 'admin',
                password: 'tes11',
                enabled: true).save(failOnError: true)
        if (!adminUser.authorities.contains(adminRole)) {
            SecUserSecRole.create adminUser, adminRole
        }
        
        def user = SecUser.findByUsername('usuari') ?: new SecUser(
                username: 'usuari',
                password: 'tst4411',
                enabled: true).save(failOnError: true)
        if (!user.authorities.contains(adminRole)) {
            SecUserSecRole.create user, userRole
        }
    }
    def destroy = {
    }
}
