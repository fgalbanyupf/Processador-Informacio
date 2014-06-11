
<%@ page import="com.ratzia.pfc.webpageanalyticaltool.BISchemaTemplate" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'BISchemaTemplate.label', default: 'BISchemaTemplate')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-BISchemaTemplate" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-BISchemaTemplate" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list BISchemaTemplate">
			
				<g:if test="${BISchemaTemplateInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="BISchemaTemplate.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${BISchemaTemplateInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<!--<g:if test="${BISchemaTemplateInstance?.code}">
				<li class="fieldcontain">
					<span id="code-label" class="property-label"><g:message code="BISchemaTemplate.code.label" default="Code" /></span>
					
						<span class="property-value" aria-labelledby="code-label"><g:fieldValue bean="${BISchemaTemplateInstance}" field="code"/></span>
					
				</li>
				</g:if>-->
			
				<!--<g:if test="${BISchemaTemplateInstance?.enabled}">
				<li class="fieldcontain">
					<span id="enabled-label" class="property-label"><g:message code="BISchemaTemplate.enabled.label" default="Enabled" /></span>
					
						<span class="property-value" aria-labelledby="enabled-label"><g:formatBoolean boolean="${BISchemaTemplateInstance?.enabled}" /></span>
					
				</li>
				</g:if>-->
			
                                <g:if test="${BISchemaTemplateInstance?.code}">
<span id="code-label" class="property-label"><g:message code="BISchemaTemplate.generatedCode.label" default="Generated Code" /></span>                                
<pre id="editor" style="height: 600px;">
${BISchemaTemplateInstance?.generatedCode}
</pre>
<script src="${createLink(uri: '/js/ace-min/ace.js')}" type="text/javascript" charset="utf-8"></script>
<script>
    var editor = ace.edit("editor");
    editor.setTheme("ace/theme/crimson_editor");
    editor.getSession().setMode("ace/mode/xml");
    editor.setReadOnly(true)

</script> 
                                </g:if>
                            <li class="fieldcontain">    
                                <ul>
                                    <li><g:link class="edit" action="cube" resource="${BISchemaTemplateInstance}"><g:message code="BISchemaTemplate.saveToSaiku.label" default="Save cube to Saiku" /></g:link><br/></li>
                                    <li><g:link class="edit" action="datawarehouseCreator" resource="${BISchemaTemplateInstance}"><g:message code="BISchemaTemplate.createDWContent.label" default="Create Datawarehouse content" /></g:link></li>
                                </ul>
                            </li>
			</ol>
                        
			<g:form url="[resource:BISchemaTemplateInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${BISchemaTemplateInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
