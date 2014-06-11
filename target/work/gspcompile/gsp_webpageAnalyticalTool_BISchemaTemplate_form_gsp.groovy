import com.ratzia.pfc.webpageanalyticaltool.BISchemaTemplate
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_webpageAnalyticalTool_BISchemaTemplate_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/BISchemaTemplate/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: BISchemaTemplateInstance, field: 'name', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("BISchemaTemplate.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("name"),'maxlength':("50"),'value':(BISchemaTemplateInstance?.name)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: BISchemaTemplateInstance, field: 'code', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("BISchemaTemplate.code.label"),'default':("Code")],-1)
printHtmlPart(5)
invokeTag('textArea','g',19,['name':("code"),'cols':("40"),'rows':("5"),'maxlength':("50000"),'required':(""),'value':(BISchemaTemplateInstance?.code)],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: BISchemaTemplateInstance, field: 'enabled', 'error'))
printHtmlPart(7)
invokeTag('message','g',25,['code':("BISchemaTemplate.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(2)
invokeTag('checkBox','g',28,['name':("enabled"),'value':(BISchemaTemplateInstance?.enabled)],-1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: BISchemaTemplateInstance, field: 'code', 'error'))
printHtmlPart(9)
invokeTag('message','g',34,['code':("BISchemaTemplateInstance.code.label"),'default':("Code")],-1)
printHtmlPart(10)
invokeTag('textArea','g',38,['id':("code_textarea"),'style':("display:none"),'name':("code"),'cols':("40"),'rows':("5"),'maxlength':("50000"),'required':(""),'value':(BISchemaTemplateInstance?.code)],-1)
printHtmlPart(11)
if(true && (BISchemaTemplateInstance?.code != null)) {
printHtmlPart(12)
expressionOut.print(BISchemaTemplateInstance?.code)
printHtmlPart(13)
}
printHtmlPart(14)
expressionOut.print(createLink(uri: '/js/ace-min/ace.js'))
printHtmlPart(15)
if(true && (BISchemaTemplateInstance?.code == null)) {
printHtmlPart(16)
expressionOut.print(createLink(uri: '/resources/bi_base_schema.xml'))
printHtmlPart(17)
}
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401562323000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
