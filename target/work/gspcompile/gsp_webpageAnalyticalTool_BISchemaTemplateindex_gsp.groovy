import com.ratzia.pfc.webpageanalyticaltool.BISchemaTemplate
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_webpageAnalyticalTool_BISchemaTemplateindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/BISchemaTemplate/index.gsp" }
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
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
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
invokeTag('message','g',15,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("create"),'action':("create")],2)
printHtmlPart(8)
invokeTag('message','g',19,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(9)
invokeTag('message','g',20,['code':("BISchemaTemplate.description")],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('sortableColumn','g',28,['property':("name"),'title':(message(code: 'BISchemaTemplate.name.label', default: 'Name'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',30,['property':("code"),'title':(message(code: 'BISchemaTemplate.code.label', default: 'Code'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',32,['property':("enabled"),'title':(message(code: 'BISchemaTemplate.enabled.label', default: 'Enabled'))],-1)
printHtmlPart(16)
loop:{
int i = 0
for( BISchemaTemplateInstance in (BISchemaTemplateInstanceList) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: BISchemaTemplateInstance, field: "name"))
})
invokeTag('link','g',40,['action':("show"),'id':(BISchemaTemplateInstance.id)],3)
printHtmlPart(19)
expressionOut.print(fieldValue(bean: BISchemaTemplateInstance, field: "code"))
printHtmlPart(20)
invokeTag('formatBoolean','g',44,['boolean':(BISchemaTemplateInstance.enabled)],-1)
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
invokeTag('paginate','g',51,['total':(BISchemaTemplateInstanceCount ?: 0)],-1)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',54,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1400778526000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
