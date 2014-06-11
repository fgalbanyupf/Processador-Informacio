import com.ratzia.pfc.webpageanalyticaltool.DBPlugin
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_webpageAnalyticalTool_DBPluginshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/DBPlugin/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'DBPlugin.label', default: 'DBPlugin'))],-1)
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
createTagBody(2, {->
printHtmlPart(14)
invokeTag('textField','g',33,['name':("fieldName"),'maxlength':("50"),'value':("")],-1)
printHtmlPart(15)
invokeTag('checkBox','g',34,['name':("fieldNullable"),'value':("true")],-1)
printHtmlPart(16)
invokeTag('select','g',35,['name':("fieldType"),'from':(com.ratzia.pfc.webpageanalyticaltool.DBFieldType?.values()),'keys':(com.ratzia.pfc.webpageanalyticaltool.DBFieldType.values()*.name()),'required':(""),'value':(DBFieldInstance?.fieldType?.name())],-1)
printHtmlPart(17)
expressionOut.print(DBPluginInstance.id)
printHtmlPart(18)
})
invokeTag('formRemote','g',39,['name':("myForm"),'method':("POST"),'url':([controller: 'DBField', action: 'ajaxSave']),'action':(createLink(controller: 'DBField', action: 'save')),'onSuccess':("fieldAdded(data)")],2)
printHtmlPart(19)
invokeTag('message','g',54,['code':("DBPlugin.name.label"),'default':("Name")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',56,['bean':(DBPluginInstance),'field':("name")],-1)
printHtmlPart(21)
if(true && (DBPluginInstance?.fields)) {
printHtmlPart(22)
invokeTag('message','g',62,['code':("DBPlugin.fields.label"),'default':("Fields")],-1)
printHtmlPart(23)
for( f in (DBPluginInstance.fields) ) {
printHtmlPart(24)
createTagBody(4, {->
expressionOut.print(f?.encodeAsHTML())
})
invokeTag('link','g',65,['controller':("DBField"),'action':("show"),'id':(f.id)],4)
printHtmlPart(25)
}
printHtmlPart(26)
}
printHtmlPart(27)
invokeTag('message','g',73,['code':("DBPlugin.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(28)
invokeTag('formatBoolean','g',75,['boolean':(DBPluginInstance?.enabled)],-1)
printHtmlPart(29)
if(true && (DBPluginInstance?.status)) {
printHtmlPart(30)
invokeTag('message','g',80,['code':("DBPlugin.enabled.status"),'default':("Status")],-1)
printHtmlPart(31)
expressionOut.print(DBPluginInstance?.status)
printHtmlPart(32)
}
printHtmlPart(33)
if(true && (DBPluginInstance?.code)) {
printHtmlPart(34)
invokeTag('message','g',85,['code':("DBPlugin.code.label"),'default':("Code")],-1)
printHtmlPart(35)
expressionOut.print(DBPluginInstance?.code)
printHtmlPart(36)
expressionOut.print(createLink(uri: '/js/ace-min/ace.js'))
printHtmlPart(37)
}
printHtmlPart(38)
createTagBody(2, {->
printHtmlPart(39)
createTagBody(3, {->
invokeTag('message','g',105,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',105,['class':("edit"),'action':("edit"),'resource':(DBPluginInstance)],3)
printHtmlPart(40)
invokeTag('actionSubmit','g',106,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(41)
})
invokeTag('form','g',108,['url':([resource:DBPluginInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(42)
})
invokeTag('captureBody','sitemesh',113,[:],1)
printHtmlPart(43)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1400143293000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
