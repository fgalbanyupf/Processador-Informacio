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
invokeTag('captureHead','sitemesh',38,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
invokeTag('message','g',40,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(8)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(9)
invokeTag('message','g',43,['code':("default.home.label")],-1)
printHtmlPart(10)
createTagBody(2, {->
invokeTag('message','g',44,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',44,['class':("list"),'action':("index")],2)
printHtmlPart(11)
createTagBody(2, {->
invokeTag('message','g',45,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',45,['class':("create"),'action':("create")],2)
printHtmlPart(12)
invokeTag('message','g',49,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(13)
if(true && (flash.message)) {
printHtmlPart(14)
expressionOut.print(flash.message)
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('message','g',55,['code':("crawlerSession.id.label"),'default':("Identifier")],-1)
printHtmlPart(17)
invokeTag('fieldValue','g',57,['bean':(crawlerSessionInstance),'field':("id")],-1)
printHtmlPart(18)
if(true && (crawlerSessionInstance?.seed)) {
printHtmlPart(19)
invokeTag('message','g',62,['code':("crawlerSession.seed.label"),'default':("Seed")],-1)
printHtmlPart(17)
invokeTag('fieldValue','g',64,['bean':(crawlerSessionInstance),'field':("seed")],-1)
printHtmlPart(18)
}
printHtmlPart(20)
if(true && (crawlerSessionInstance?.numCrawlers)) {
printHtmlPart(21)
invokeTag('message','g',71,['code':("crawlerSession.numCrawlers.label"),'default':("Num Crawlers")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',73,['bean':(crawlerSessionInstance),'field':("numCrawlers")],-1)
printHtmlPart(18)
}
printHtmlPart(20)
if(true && (crawlerSessionInstance?.depth)) {
printHtmlPart(23)
invokeTag('message','g',80,['code':("crawlerSession.depth.label"),'default':("Depth")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',82,['bean':(crawlerSessionInstance),'field':("depth")],-1)
printHtmlPart(18)
}
printHtmlPart(20)
if(true && (crawlerSessionInstance?.dateCreated)) {
printHtmlPart(25)
invokeTag('message','g',89,['code':("crawlerSession.dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(26)
invokeTag('formatDate','g',91,['date':(crawlerSessionInstance?.dateCreated)],-1)
printHtmlPart(18)
}
printHtmlPart(20)
if(true && (crawlerSessionInstance?.jail)) {
printHtmlPart(27)
invokeTag('message','g',98,['code':("crawlerSession.jail.label"),'default':("Jail")],-1)
printHtmlPart(28)
invokeTag('fieldValue','g',100,['bean':(crawlerSessionInstance),'field':("jail")],-1)
printHtmlPart(18)
}
printHtmlPart(20)
if(true && (crawlerSessionInstance?.lastUpdated)) {
printHtmlPart(29)
invokeTag('message','g',107,['code':("crawlerSession.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(30)
invokeTag('formatDate','g',109,['date':(crawlerSessionInstance?.lastUpdated)],-1)
printHtmlPart(18)
}
printHtmlPart(31)
invokeTag('message','g',115,['code':("crawlerSession.status.label"),'default':("Status")],-1)
printHtmlPart(32)
expressionOut.print(crawlerSessionInstance?.status)
printHtmlPart(33)
expressionOut.print(resource(dir:'images',file:'spinner_arr_whitebg.gif'))
printHtmlPart(34)
expressionOut.print(message(code:'spinner.alt',default:'Loading...'))
printHtmlPart(35)
invokeTag('message','g',122,['code':("crawlerSession.pageCount.label"),'default':("Page count")],-1)
printHtmlPart(36)
expressionOut.print(crawlerSessionInstance?.pageCount)
printHtmlPart(37)
createTagBody(2, {->
invokeTag('message','g',130,['code':("crawlerSession.stop.label"),'default':("Stop")],-1)
})
invokeTag('link','g',130,['class':("edit"),'action':("stop"),'resource':(crawlerSessionInstance)],2)
printHtmlPart(38)
createTagBody(2, {->
invokeTag('message','g',136,['code':("crawlerSession.resume.label"),'default':("Resume")],-1)
})
invokeTag('link','g',136,['class':("edit"),'action':("resume"),'resource':(crawlerSessionInstance)],2)
printHtmlPart(39)
createTagBody(2, {->
printHtmlPart(40)
createTagBody(3, {->
invokeTag('message','g',150,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',150,['class':("edit"),'action':("edit"),'resource':(crawlerSessionInstance)],3)
printHtmlPart(41)
invokeTag('actionSubmit','g',151,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(42)
})
invokeTag('form','g',153,['url':([resource:crawlerSessionInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(43)
})
invokeTag('captureBody','sitemesh',155,[:],1)
printHtmlPart(44)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1403789449000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
