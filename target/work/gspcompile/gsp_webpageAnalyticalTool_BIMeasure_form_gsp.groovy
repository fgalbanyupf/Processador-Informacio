import com.ratzia.pfc.webpageanalyticaltool.BIMeasure
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_webpageAnalyticalTool_BIMeasure_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/BIMeasure/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: BIMeasureInstance, field: 'name', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("BIMeasure.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("name"),'maxlength':("50"),'value':(BIMeasureInstance?.name)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: BIMeasureInstance, field: 'aggregator', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("BIMeasure.aggregator.label"),'default':("Aggregator")],-1)
printHtmlPart(5)
invokeTag('select','g',19,['name':("aggregator"),'from':(com.ratzia.pfc.webpageanalyticaltool.BIAggregator?.values()),'keys':(com.ratzia.pfc.webpageanalyticaltool.BIAggregator.values()*.name()),'required':(""),'value':(BIMeasureInstance?.aggregator?.name())],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: BIMeasureInstance, field: 'field', 'error'))
printHtmlPart(6)
invokeTag('message','g',25,['code':("BIMeasure.field.label"),'default':("Field")],-1)
printHtmlPart(5)
invokeTag('select','g',28,['id':("field"),'name':("field.id"),'from':(com.ratzia.pfc.webpageanalyticaltool.DBField.findAllByIsCollection(false)),'optionKey':("id"),'required':(""),'value':(BIMeasureInstance?.field?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: BIMeasureInstance, field: 'visible', 'error'))
printHtmlPart(7)
invokeTag('message','g',34,['code':("BIMeasure.visible.label"),'default':("Visible")],-1)
printHtmlPart(2)
invokeTag('checkBox','g',37,['name':("visible"),'value':(BIMeasureInstance?.visible)],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1400583883000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
