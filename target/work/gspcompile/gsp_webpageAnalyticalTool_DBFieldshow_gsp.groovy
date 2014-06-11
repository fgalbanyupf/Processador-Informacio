import com.ratzia.pfc.webpageanalyticaltool.DBField
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_webpageAnalyticalTool_DBFieldshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/DBField/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'DBField.label', default: 'DBField'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (DBFieldInstance?.fieldName)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("DBField.fieldName.label"),'default':("Field Name")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(DBFieldInstance),'field':("fieldName")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (DBFieldInstance?.plugin)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("DBField.plugin.label"),'default':("Plugin")],-1)
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(DBFieldInstance?.plugin?.encodeAsHTML())
})
invokeTag('link','g',39,['controller':("DBPlugin"),'action':("show"),'id':(DBFieldInstance?.plugin?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (DBFieldInstance?.dateCreated)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("DBField.dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(21)
invokeTag('formatDate','g',48,['date':(DBFieldInstance?.dateCreated)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (DBFieldInstance?.descriptiveName)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("DBField.descriptiveName.label"),'default':("Descriptive Name")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',57,['bean':(DBFieldInstance),'field':("descriptiveName")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (DBFieldInstance?.fieldNullable)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("DBField.fieldNullable.label"),'default':("Field Nullable")],-1)
printHtmlPart(25)
invokeTag('formatBoolean','g',66,['boolean':(DBFieldInstance?.fieldNullable)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (DBFieldInstance?.fieldType)) {
printHtmlPart(26)
invokeTag('message','g',73,['code':("DBField.fieldType.label"),'default':("Field Type")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',75,['bean':(DBFieldInstance),'field':("fieldType")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (DBFieldInstance?.isCollection)) {
printHtmlPart(28)
invokeTag('message','g',82,['code':("DBField.isCollection.label"),'default':("Is Collection")],-1)
printHtmlPart(29)
invokeTag('formatBoolean','g',84,['boolean':(DBFieldInstance?.isCollection)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (DBFieldInstance?.lastUpdated)) {
printHtmlPart(30)
invokeTag('message','g',91,['code':("DBField.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(31)
invokeTag('formatDate','g',93,['date':(DBFieldInstance?.lastUpdated)],-1)
printHtmlPart(16)
}
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(33)
if(true && ("!DBFieldInstance.pluginField")) {
printHtmlPart(34)
createTagBody(4, {->
invokeTag('message','g',102,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',102,['class':("edit"),'action':("edit"),'resource':(DBFieldInstance)],4)
printHtmlPart(35)
}
printHtmlPart(36)
invokeTag('actionSubmit','g',104,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(37)
})
invokeTag('form','g',106,['url':([resource:DBFieldInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(38)
})
invokeTag('captureBody','sitemesh',108,[:],1)
printHtmlPart(39)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1400571754000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
