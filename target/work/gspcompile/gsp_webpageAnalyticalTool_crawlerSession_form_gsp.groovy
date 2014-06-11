import com.ratzia.pfc.webpageanalyticaltool.CrawlerSession
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_webpageAnalyticalTool_crawlerSession_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/crawlerSession/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: crawlerSessionInstance, field: 'seed', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("crawlerSession.seed.label"),'default':("Seed")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("seed"),'maxlength':("100"),'value':(crawlerSessionInstance?.seed)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: crawlerSessionInstance, field: 'numCrawlers', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("crawlerSession.numCrawlers.label"),'default':("Num Crawlers")],-1)
printHtmlPart(5)
invokeTag('field','g',19,['name':("numCrawlers"),'type':("number"),'value':(crawlerSessionInstance.numCrawlers),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: crawlerSessionInstance, field: 'depth', 'error'))
printHtmlPart(6)
invokeTag('message','g',25,['code':("crawlerSession.depth.label"),'default':("Depth")],-1)
printHtmlPart(5)
invokeTag('field','g',28,['name':("depth"),'type':("number"),'value':(crawlerSessionInstance.depth),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: crawlerSessionInstance, field: 'jail', 'error'))
printHtmlPart(7)
invokeTag('message','g',34,['code':("crawlerSession.jail.label"),'default':("Jail")],-1)
printHtmlPart(2)
invokeTag('textField','g',37,['name':("jail"),'value':(crawlerSessionInstance?.jail)],-1)
printHtmlPart(8)
invokeTag('message','g',38,['code':("crawlerSession.jail.hint.label"),'default':("Regular Expression")],-1)
printHtmlPart(9)
invokeTag('message','g',40,['code':("crawlerSession.jail.examples.label"),'default':("Examples")],-1)
printHtmlPart(10)
invokeTag('message','g',42,['code':("crawlerSession.jail.examples.any"),'default':("Follow all links")],-1)
printHtmlPart(11)
invokeTag('message','g',43,['code':("crawlerSession.jail.examples.upf"),'default':("Follow all webpages in upf.edu including subdomains")],-1)
printHtmlPart(12)
invokeTag('message','g',44,['code':("crawlerSession.jail.examples.cat"),'default':("Follow all webpages in cat TLD")],-1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401204987000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
