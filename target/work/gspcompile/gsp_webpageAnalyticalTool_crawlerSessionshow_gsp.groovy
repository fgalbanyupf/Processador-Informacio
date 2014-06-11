import com.ratzia.pfc.webpageanalyticaltool.CrawlerSession
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_webpageAnalyticalTool_crawlerSessionshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/crawlerSession/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'crawlerSession.label', default: 'CrawlerSession'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
expressionOut.print(createLink(controller:'crawlerSession', action:'ajaxCrawlerStatus'))
printHtmlPart(4)
expressionOut.print(crawlerSessionInstance?.id)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',25,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
invokeTag('message','g',27,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(8)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(9)
invokeTag('message','g',30,['code':("default.home.label")],-1)
printHtmlPart(10)
createTagBody(2, {->
invokeTag('message','g',31,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',31,['class':("list"),'action':("index")],2)
printHtmlPart(11)
createTagBody(2, {->
invokeTag('message','g',32,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',32,['class':("create"),'action':("create")],2)
printHtmlPart(12)
invokeTag('message','g',36,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(13)
if(true && (flash.message)) {
printHtmlPart(14)
expressionOut.print(flash.message)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (crawlerSessionInstance?.seed)) {
printHtmlPart(17)
invokeTag('message','g',44,['code':("crawlerSession.seed.label"),'default':("Seed")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',46,['bean':(crawlerSessionInstance),'field':("seed")],-1)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (crawlerSessionInstance?.numCrawlers)) {
printHtmlPart(21)
invokeTag('message','g',53,['code':("crawlerSession.numCrawlers.label"),'default':("Num Crawlers")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',55,['bean':(crawlerSessionInstance),'field':("numCrawlers")],-1)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (crawlerSessionInstance?.depth)) {
printHtmlPart(23)
invokeTag('message','g',62,['code':("crawlerSession.depth.label"),'default':("Depth")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',64,['bean':(crawlerSessionInstance),'field':("depth")],-1)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (crawlerSessionInstance?.dateCreated)) {
printHtmlPart(25)
invokeTag('message','g',71,['code':("crawlerSession.dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(26)
invokeTag('formatDate','g',73,['date':(crawlerSessionInstance?.dateCreated)],-1)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (crawlerSessionInstance?.jail)) {
printHtmlPart(27)
invokeTag('message','g',80,['code':("crawlerSession.jail.label"),'default':("Jail")],-1)
printHtmlPart(28)
invokeTag('fieldValue','g',82,['bean':(crawlerSessionInstance),'field':("jail")],-1)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (crawlerSessionInstance?.lastUpdated)) {
printHtmlPart(29)
invokeTag('message','g',89,['code':("crawlerSession.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(30)
invokeTag('formatDate','g',91,['date':(crawlerSessionInstance?.lastUpdated)],-1)
printHtmlPart(19)
}
printHtmlPart(31)
expressionOut.print(crawlerSessionInstance?.status)
printHtmlPart(32)
expressionOut.print(resource(dir:'images',file:'spinner_arr_whitebg.gif'))
printHtmlPart(33)
expressionOut.print(message(code:'spinner.alt',default:'Loading...'))
printHtmlPart(34)
if(true && (crawlerSessionInstance?.running)) {
printHtmlPart(35)
createTagBody(3, {->
invokeTag('message','g',105,['code':("crawlerSession.stop.label"),'default':("Stop")],-1)
})
invokeTag('link','g',105,['class':("edit"),'action':("stop"),'resource':(crawlerSessionInstance)],3)
printHtmlPart(36)
}
printHtmlPart(37)
createTagBody(2, {->
printHtmlPart(38)
createTagBody(3, {->
invokeTag('message','g',119,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',119,['class':("edit"),'action':("edit"),'resource':(crawlerSessionInstance)],3)
printHtmlPart(39)
invokeTag('actionSubmit','g',120,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(40)
})
invokeTag('form','g',122,['url':([resource:crawlerSessionInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(41)
})
invokeTag('captureBody','sitemesh',124,[:],1)
printHtmlPart(42)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401205241000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
