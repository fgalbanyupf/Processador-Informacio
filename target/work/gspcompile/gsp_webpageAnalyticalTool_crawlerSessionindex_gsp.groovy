import com.ratzia.pfc.webpageanalyticaltool.CrawlerSession
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_webpageAnalyticalTool_crawlerSessionindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/crawlerSession/index.gsp" }
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
invokeTag('message','g',20,['code':("crawlerSession.description")],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('sortableColumn','g',27,['property':("id"),'title':(message(code: 'crawlerSession.id.label', default: 'Identifier'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',29,['property':("seed"),'title':(message(code: 'crawlerSession.seed.label', default: 'Seed'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',31,['property':("numCrawlers"),'title':(message(code: 'crawlerSession.numCrawlers.label', default: 'Num Crawlers'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',33,['property':("depth"),'title':(message(code: 'crawlerSession.depth.label', default: 'Depth'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',35,['property':("dateCreated"),'title':(message(code: 'crawlerSession.dateCreated.label', default: 'Date Created'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',37,['property':("jail"),'title':(message(code: 'crawlerSession.jail.label', default: 'Jail'))],-1)
printHtmlPart(18)
loop:{
int i = 0
for( crawlerSessionInstance in (crawlerSessionInstanceList) ) {
printHtmlPart(19)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(20)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: crawlerSessionInstance, field: "id"))
})
invokeTag('link','g',44,['action':("show"),'id':(crawlerSessionInstance.id),'class':("urlWidth")],3)
printHtmlPart(21)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: crawlerSessionInstance, field: "seed"))
})
invokeTag('link','g',45,['action':("show"),'id':(crawlerSessionInstance.id),'class':("urlWidth")],3)
printHtmlPart(22)
expressionOut.print(fieldValue(bean: crawlerSessionInstance, field: "numCrawlers"))
printHtmlPart(23)
expressionOut.print(fieldValue(bean: crawlerSessionInstance, field: "depth"))
printHtmlPart(24)
invokeTag('formatDate','g',51,['date':(crawlerSessionInstance.dateCreated)],-1)
printHtmlPart(22)
expressionOut.print(fieldValue(bean: crawlerSessionInstance, field: "jail"))
printHtmlPart(25)
i++
}
}
printHtmlPart(26)
invokeTag('paginate','g',60,['total':(crawlerSessionInstanceCount ?: 0)],-1)
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',63,[:],1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1403788515000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
