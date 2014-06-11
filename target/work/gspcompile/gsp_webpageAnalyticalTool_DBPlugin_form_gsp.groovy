import com.ratzia.pfc.webpageanalyticaltool.DBPlugin
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_webpageAnalyticalTool_DBPlugin_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/DBPlugin/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: DBPluginInstance, field: 'name', 'error'))
printHtmlPart(1)
invokeTag('message','g',6,['code':("DBPlugin.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',9,['id':("pluginName"),'name':("name"),'value':(DBPluginInstance?.name)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: DBPluginInstance, field: 'fields', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("DBPlugin.fields.label"),'default':("Fields")],-1)
printHtmlPart(2)
invokeTag('select','g',18,['name':("fields"),'from':(com.ratzia.pfc.webpageanalyticaltool.DBField.list()),'multiple':("multiple"),'optionKey':("id"),'size':("5"),'value':(DBPluginInstance?.fields*.id),'class':("many-to-many")],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: DBPluginInstance, field: 'enabled', 'error'))
printHtmlPart(6)
invokeTag('message','g',24,['code':("DBPlugin.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(2)
invokeTag('checkBox','g',27,['name':("enabled"),'value':(DBPluginInstance?.enabled)],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: DBPluginInstance, field: 'code', 'error'))
printHtmlPart(8)
invokeTag('message','g',32,['code':("DBPlugin.code.label"),'default':("Code")],-1)
printHtmlPart(9)
invokeTag('textArea','g',36,['id':("code_textarea"),'style':("display:none"),'name':("code"),'cols':("40"),'rows':("5"),'maxlength':("50000"),'required':(""),'value':(DBPluginInstance?.code)],-1)
printHtmlPart(10)
if(true && (DBPluginInstance?.code != null)) {
printHtmlPart(11)
expressionOut.print(DBPluginInstance?.code)
printHtmlPart(12)
}
else {
printHtmlPart(13)
}
printHtmlPart(14)
expressionOut.print(createLink(uri: '/js/ace-min/ace.js'))
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1400144489000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
