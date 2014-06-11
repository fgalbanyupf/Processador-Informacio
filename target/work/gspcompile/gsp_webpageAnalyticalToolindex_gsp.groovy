import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_webpageAnalyticalToolindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
invokeTag('captureTitle','sitemesh',5,[:],-1)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',46,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',49,['code':("application.title")],-1)
printHtmlPart(5)
invokeTag('message','g',50,['code':("application.introText")],-1)
printHtmlPart(6)
invokeTag('message','g',52,['code':("application.dbTools.label"),'default':("Database definition")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',53,['code':("DBField.label"),'default':("Database Field")],-1)
})
invokeTag('link','g',53,['controller':("DBField")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',54,['code':("DBPlugin.label"),'default':("Database Plugin")],-1)
})
invokeTag('link','g',54,['controller':("DBPlugin")],2)
printHtmlPart(9)
invokeTag('message','g',56,['code':("application.biTools.label"),'default':("Business Intelligence")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',57,['code':("BIDimension.label"),'default':("Dimension")],-1)
})
invokeTag('link','g',57,['controller':("BIDimension")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',58,['code':("BIMeasure.label"),'default':("Measure")],-1)
})
invokeTag('link','g',58,['controller':("BIMeasure")],2)
printHtmlPart(10)
createTagBody(2, {->
invokeTag('message','g',59,['code':("BISchemaTemplate.label"),'default':("Schema Template")],-1)
})
invokeTag('link','g',59,['controller':("BISchemaTemplate")],2)
printHtmlPart(11)
expressionOut.print(grailsApplication.config.bisystem.link)
printHtmlPart(12)
invokeTag('message','g',60,['code':("application.accessSaiku.label"),'default':("Go to Saiku")],-1)
printHtmlPart(13)
invokeTag('message','g',62,['code':("application.crawlerTools.label"),'default':("Web crawling")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',63,['code':("crawlerSession.label"),'default':("Crawler Session")],-1)
})
invokeTag('link','g',63,['controller':("crawlerSession")],2)
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',66,[:],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401562052000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
