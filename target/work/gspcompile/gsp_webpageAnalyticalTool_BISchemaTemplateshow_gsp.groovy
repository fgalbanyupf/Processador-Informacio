import com.ratzia.pfc.webpageanalyticaltool.BISchemaTemplate
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_webpageAnalyticalTool_BISchemaTemplateshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/BISchemaTemplate/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'BISchemaTemplate.label', default: 'BISchemaTemplate'))],-1)
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
if(true && (BISchemaTemplateInstance?.name)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("BISchemaTemplate.name.label"),'default':("Name")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(BISchemaTemplateInstance),'field':("name")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (BISchemaTemplateInstance?.code)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("BISchemaTemplate.code.label"),'default':("Code")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(BISchemaTemplateInstance),'field':("code")],-1)
printHtmlPart(16)
}
printHtmlPart(20)
if(true && (BISchemaTemplateInstance?.enabled)) {
printHtmlPart(21)
invokeTag('message','g',46,['code':("BISchemaTemplate.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(22)
invokeTag('formatBoolean','g',48,['boolean':(BISchemaTemplateInstance?.enabled)],-1)
printHtmlPart(16)
}
printHtmlPart(23)
if(true && (BISchemaTemplateInstance?.code)) {
printHtmlPart(24)
invokeTag('message','g',54,['code':("BISchemaTemplate.generatedCode.label"),'default':("Generated Code")],-1)
printHtmlPart(25)
expressionOut.print(BISchemaTemplateInstance?.generatedCode)
printHtmlPart(26)
expressionOut.print(createLink(uri: '/js/ace-min/ace.js'))
printHtmlPart(27)
}
printHtmlPart(28)
createTagBody(2, {->
invokeTag('message','g',69,['code':("BISchemaTemplate.saveToSaiku.label"),'default':("Save cube to Saiku")],-1)
})
invokeTag('link','g',69,['class':("edit"),'action':("cube"),'resource':(BISchemaTemplateInstance)],2)
printHtmlPart(29)
createTagBody(2, {->
invokeTag('message','g',70,['code':("BISchemaTemplate.createDWContent.label"),'default':("Create Datawarehouse content")],-1)
})
invokeTag('link','g',70,['class':("edit"),'action':("datawarehouseCreator"),'resource':(BISchemaTemplateInstance)],2)
printHtmlPart(30)
createTagBody(2, {->
printHtmlPart(31)
createTagBody(3, {->
invokeTag('message','g',77,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',77,['class':("edit"),'action':("edit"),'resource':(BISchemaTemplateInstance)],3)
printHtmlPart(32)
invokeTag('actionSubmit','g',78,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(33)
})
invokeTag('form','g',80,['url':([resource:BISchemaTemplateInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(34)
})
invokeTag('captureBody','sitemesh',82,[:],1)
printHtmlPart(35)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401562334000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
