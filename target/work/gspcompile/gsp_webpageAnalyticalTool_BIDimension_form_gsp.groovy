import com.ratzia.pfc.webpageanalyticaltool.BIDimension
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_webpageAnalyticalTool_BIDimension_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/BIDimension/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: BIDimensionInstance, field: 'name', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("BIDimension.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("name"),'maxlength':("50"),'value':(BIDimensionInstance?.name)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: BIDimensionInstance, field: 'fields', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("BIDimension.fields.label"),'default':("Fields")],-1)
printHtmlPart(2)
invokeTag('select','g',19,['name':("fields"),'from':(com.ratzia.pfc.webpageanalyticaltool.DBField.findAllNotIsCollection()),'multiple':("multiple"),'optionKey':("id"),'size':("5"),'value':(BIDimensionInstance?.fields*.id),'class':("one-to-many")],-1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401563597000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
