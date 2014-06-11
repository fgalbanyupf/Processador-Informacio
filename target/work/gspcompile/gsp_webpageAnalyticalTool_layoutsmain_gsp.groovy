import com.ratzia.pfc.webpageanalyticaltool.BackgroundProcessStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_webpageAnalyticalTool_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',11,['code':("application.title")],-1)
printHtmlPart(2)
invokeTag('layoutTitle','g',11,['default':("")],-1)
})
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(3)
expressionOut.print(resource(dir: 'images', file: 'favicon.ico'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'images', file: 'apple-touch-icon.png'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'images', file: 'apple-touch-icon-retina.png'))
printHtmlPart(6)
expressionOut.print(resource(dir: 'css', file: 'main.css'))
printHtmlPart(7)
expressionOut.print(resource(dir: 'css', file: 'mobile.css'))
printHtmlPart(8)
invokeTag('javascript','g',18,['library':("application")],-1)
printHtmlPart(9)
invokeTag('javascript','g',19,['library':("jquery"),'plugin':("jquery")],-1)
printHtmlPart(1)
invokeTag('layoutResources','r',20,[:],-1)
printHtmlPart(10)
invokeTag('layoutHead','g',21,[:],-1)
printHtmlPart(11)
expressionOut.print(BackgroundProcessStatus.RUNNING)
printHtmlPart(12)
expressionOut.print(BackgroundProcessStatus.STOPPED)
printHtmlPart(13)
expressionOut.print(BackgroundProcessStatus.IDLE)
printHtmlPart(14)
expressionOut.print(createLink(controller:'crawlerSession', action:'show'))
printHtmlPart(15)
expressionOut.print(createLink(controller:'SystemStatus', action:'startProcess'))
printHtmlPart(16)
expressionOut.print(createLink(controller:'SystemStatus', action:'stopProcess'))
printHtmlPart(17)
expressionOut.print(createLink(controller:'SystemStatus', action:'processesStatus'))
printHtmlPart(18)
expressionOut.print(resource(dir:'images',file:'running.gif'))
printHtmlPart(19)
expressionOut.print(resource(dir:'images',file:'running.gif'))
printHtmlPart(20)
})
invokeTag('captureHead','sitemesh',85,[:],1)
printHtmlPart(21)
createTagBody(1, {->
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
invokeTag('message','g',92,['code':("application.dbTools.label"),'default':("Database definition")],-1)
printHtmlPart(24)
createTagBody(3, {->
invokeTag('message','g',93,['code':("DBField.label"),'default':("Database Field")],-1)
})
invokeTag('link','g',93,['controller':("DBField")],3)
printHtmlPart(25)
createTagBody(3, {->
invokeTag('message','g',94,['code':("DBPlugin.label"),'default':("Database Plugin")],-1)
})
invokeTag('link','g',94,['controller':("DBPlugin")],3)
printHtmlPart(26)
invokeTag('message','g',96,['code':("application.biTools.label"),'default':("Business Intelligence")],-1)
printHtmlPart(24)
createTagBody(3, {->
invokeTag('message','g',97,['code':("BIDimension.label"),'default':("Dimension")],-1)
})
invokeTag('link','g',97,['controller':("BIDimension")],3)
printHtmlPart(25)
createTagBody(3, {->
invokeTag('message','g',98,['code':("BIMeasure.label"),'default':("Measure")],-1)
})
invokeTag('link','g',98,['controller':("BIMeasure")],3)
printHtmlPart(27)
createTagBody(3, {->
invokeTag('message','g',99,['code':("BISchemaTemplate.label"),'default':("Schema Template")],-1)
})
invokeTag('link','g',99,['controller':("BISchemaTemplate")],3)
printHtmlPart(28)
expressionOut.print(grailsApplication.config.bisystem.link)
printHtmlPart(29)
invokeTag('message','g',100,['code':("application.accessSaiku.label"),'default':("Go to Saiku")],-1)
printHtmlPart(30)
invokeTag('message','g',102,['code':("application.crawlerTools.label"),'default':("Web crawling")],-1)
printHtmlPart(24)
createTagBody(3, {->
invokeTag('message','g',103,['code':("crawlerSession.label"),'default':("Crawler Session")],-1)
})
invokeTag('link','g',103,['controller':("crawlerSession")],3)
printHtmlPart(31)
invokeTag('message','g',108,['code':("application.backgroundprocesses.label"),'default':("Background Processes")],-1)
printHtmlPart(32)
invokeTag('message','g',113,['code':("application.runningCrawlers.label"),'default':("Running Crawlers")],-1)
printHtmlPart(33)
expressionOut.print(resource(dir:'images',file:'spinner_arr.gif'))
printHtmlPart(34)
expressionOut.print(message(code:'spinner.alt',default:'Loading...'))
printHtmlPart(35)
createTagBody(3, {->
invokeTag('message','g',120,['code':("application.backgroundprocesses.forceDBE.label"),'default':("Force-execute DB Expander")],-1)
})
invokeTag('link','g',120,['controller':("SystemStatus"),'action':("launchExpander"),'params':([targetUri: (request.forwardURI - request.contextPath)])],3)
printHtmlPart(36)
})
invokeTag('ifLoggedIn','sec',122,[:],2)
printHtmlPart(37)
invokeTag('layoutBody','g',124,[:],-1)
printHtmlPart(38)
invokeTag('message','g',126,['code':("spinner.alt"),'default':("Loading&hellip;")],-1)
printHtmlPart(39)
invokeTag('layoutResources','r',127,[:],-1)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',128,[:],1)
printHtmlPart(40)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401974326000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
