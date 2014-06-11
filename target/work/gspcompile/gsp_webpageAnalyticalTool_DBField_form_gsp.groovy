import com.ratzia.pfc.webpageanalyticaltool.DBField
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_webpageAnalyticalTool_DBField_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/DBField/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: DBFieldInstance, field: 'fieldName', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("DBField.fieldName.label"),'default':("Field Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("fieldName"),'pattern':("[A-Za-z_]+"),'maxlength':("50"),'value':(DBFieldInstance?.fieldName)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: DBFieldInstance, field: 'plugin', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("DBField.plugin.label"),'default':("Plugin")],-1)
printHtmlPart(2)
invokeTag('select','g',19,['id':("plugin"),'name':("plugin.id"),'from':(com.ratzia.pfc.webpageanalyticaltool.DBPlugin.list()),'optionKey':("id"),'value':(DBFieldInstance?.plugin?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: DBFieldInstance, field: 'descriptiveName', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("DBField.descriptiveName.label"),'default':("Descriptive Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',28,['name':("descriptiveName"),'value':(DBFieldInstance?.descriptiveName)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: DBFieldInstance, field: 'fieldNullable', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("DBField.fieldNullable.label"),'default':("Field Nullable")],-1)
printHtmlPart(2)
invokeTag('checkBox','g',37,['name':("fieldNullable"),'value':(DBFieldInstance?.fieldNullable)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: DBFieldInstance, field: 'fieldType', 'error'))
printHtmlPart(7)
invokeTag('message','g',43,['code':("DBField.fieldType.label"),'default':("Field Type")],-1)
printHtmlPart(8)
invokeTag('select','g',46,['name':("fieldType"),'from':(com.ratzia.pfc.webpageanalyticaltool.DBFieldType?.values()),'keys':(com.ratzia.pfc.webpageanalyticaltool.DBFieldType.values()*.name()),'required':(""),'value':(DBFieldInstance?.fieldType?.name())],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: DBFieldInstance, field: 'isCollection', 'error'))
printHtmlPart(9)
invokeTag('message','g',52,['code':("DBField.isCollection.label"),'default':("Is Collection")],-1)
printHtmlPart(2)
invokeTag('checkBox','g',55,['name':("isCollection"),'value':(DBFieldInstance?.isCollection)],-1)
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1400571675000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
