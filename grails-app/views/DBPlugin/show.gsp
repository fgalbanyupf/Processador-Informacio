
<%@ page import="com.ratzia.pfc.webpageanalyticaltool.DBPlugin" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'DBPlugin.label', default: 'DBPlugin')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-DBPlugin" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-DBPlugin" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list DBPlugin">
                            <!-- -->        
<!-- ***SANDBOOOOX***  http://blog.datenwerke.net/2013/06/sandboxing-groovy-with-java-sandbox.html
PENDENT FER TEST AMB UN RECORD DE LA MONGODB!
                            <div style="border:1px solid #F00">  
                                <g:formRemote name="myForm"  method="POST"
                                    url="[controller: 'DBField', action: 'ajaxSave']"
                                    action="${createLink(controller: 'DBField', action: 'save')}"
                                    onSuccess="fieldAdded(data)">
                                    Name <g:textField name="fieldName" maxlength="50" value=""/><br/>
                                    Nullable <g:checkBox name="fieldNullable" value="true" /><br/>
                                    Type <g:select name="fieldType" from="${com.ratzia.pfc.webpageanalyticaltool.DBFieldType?.values()}" keys="${com.ratzia.pfc.webpageanalyticaltool.DBFieldType.values()*.name()}" required="" value="${DBFieldInstance?.fieldType?.name()}" />                        
                                    <input name="plugin" type="hidden" value="${DBPluginInstance.id}"/>
                                    <input name="pluginField" type="hidden" value="1"/>
                                    <input type="submit" value="Submit">
                                </g:formRemote>
                                
                                <script>
                                    function fieldAdded(data){
                                    console.log(data);
                                        $('#fields').append('<span class="property-value" aria-labelledby="fields-label">' + data.DBFieldInstance + '</span>');
                                    }
                                

                                </script>
                            </div>   
                            <hr/>-->
                            <!-- -->
                            
                                <li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="DBPlugin.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${DBPluginInstance}" field="name"/></span>
					
				</li>
                                
				<g:if test="${DBPluginInstance?.fields}">
				<li class="fieldcontain">
					<span id="fields-label" class="property-label"><g:message code="DBPlugin.fields.label" default="Fields" /></span>
					<div id="fields">
						<g:each in="${DBPluginInstance.fields}" var="f">
						<span class="property-value" aria-labelledby="fields-label"><g:link controller="DBField" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></span>
						</g:each>
					</div>
				</li>
				</g:if>
                                
                                		
				<li class="fieldcontain">
					<span id="enabled-label" class="property-label"><g:message code="DBPlugin.enabled.label" default="Enabled" /></span>
					
						<span class="property-value" aria-labelledby="enabled-label"><g:formatBoolean boolean="${DBPluginInstance?.enabled}" /></span>
					
				</li>
                                
                                <g:if test="${DBPluginInstance?.status}">
					<span id="enabled-label" class="property-label"><g:message code="DBPlugin.enabled.status" default="Status" /></span>
					<pre style="color:red">${DBPluginInstance?.status}</pre>
				</g:if>
			
                                <g:if test="${DBPluginInstance?.code}">
<span id="code-label" class="property-label"><g:message code="DBPlugin.code.label" default="Code" /></span>                                
<pre id="editor" style="height: 600px;">
${DBPluginInstance?.code}
</pre>
<script src="${createLink(uri: '/js/ace-min/ace.js')}" type="text/javascript" charset="utf-8"></script>
<script>
    var editor = ace.edit("editor");
    editor.setTheme("ace/theme/crimson_editor");
    editor.getSession().setMode("ace/mode/groovy");
    editor.setReadOnly(true)

</script> 
    
                                
				</g:if>
				
			
			</ol>
			<g:form url="[resource:DBPluginInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${DBPluginInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
                
                
                
	</body>
</html>
