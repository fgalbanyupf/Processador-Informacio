import com.ratzia.pfc.webpageanalyticaltool.DBField
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_webpageAnalyticalTool_DBFieldindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/DBField/index.gsp" }
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
invokeTag('message','g',20,['code':("DBField.description")],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('sortableColumn','g',28,['property':("fieldName"),'title':(message(code: 'DBField.fieldName.label', default: 'Field Name'))],-1)
printHtmlPart(14)
invokeTag('message','g',30,['code':("DBField.plugin.label"),'default':("Plugin")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',32,['property':("dateCreated"),'title':(message(code: 'DBField.dateCreated.label', default: 'Date Created'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',34,['property':("descriptiveName"),'title':(message(code: 'DBField.descriptiveName.label', default: 'Descriptive Name'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',36,['property':("fieldNullable"),'title':(message(code: 'DBField.fieldNullable.label', default: 'Field Nullable'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',38,['property':("fieldType"),'title':(message(code: 'DBField.fieldType.label', default: 'Field Type'))],-1)
printHtmlPart(17)
loop:{
int i = 0
for( DBFieldInstance in (DBFieldInstanceList) ) {
printHtmlPart(18)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: DBFieldInstance, field: "fieldName"))
})
invokeTag('link','g',46,['action':("show"),'id':(DBFieldInstance.id)],3)
printHtmlPart(20)
expressionOut.print(fieldValue(bean: DBFieldInstance, field: "plugin"))
printHtmlPart(20)
invokeTag('formatDate','g',50,['date':(DBFieldInstance.dateCreated)],-1)
printHtmlPart(20)
expressionOut.print(fieldValue(bean: DBFieldInstance, field: "descriptiveName"))
printHtmlPart(20)
invokeTag('formatBoolean','g',54,['boolean':(DBFieldInstance.fieldNullable)],-1)
printHtmlPart(20)
expressionOut.print(fieldValue(bean: DBFieldInstance, field: "fieldType"))
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
invokeTag('paginate','g',63,['total':(DBFieldInstanceCount ?: 0)],-1)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',66,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1400779330000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
