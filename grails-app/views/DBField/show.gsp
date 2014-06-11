
<%@ page import="com.ratzia.pfc.webpageanalyticaltool.DBField" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'DBField.label', default: 'DBField')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-DBField" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-DBField" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list DBField">
			
				<g:if test="${DBFieldInstance?.fieldName}">
				<li class="fieldcontain">
					<span id="fieldName-label" class="property-label"><g:message code="DBField.fieldName.label" default="Field Name" /></span>
					
						<span class="property-value" aria-labelledby="fieldName-label"><g:fieldValue bean="${DBFieldInstance}" field="fieldName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${DBFieldInstance?.plugin}">
				<li class="fieldcontain">
					<span id="plugin-label" class="property-label"><g:message code="DBField.plugin.label" default="Plugin" /></span>
					
						<span class="property-value" aria-labelledby="plugin-label"><g:link controller="DBPlugin" action="show" id="${DBFieldInstance?.plugin?.id}">${DBFieldInstance?.plugin?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${DBFieldInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="DBField.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${DBFieldInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${DBFieldInstance?.descriptiveName}">
				<li class="fieldcontain">
					<span id="descriptiveName-label" class="property-label"><g:message code="DBField.descriptiveName.label" default="Descriptive Name" /></span>
					
						<span class="property-value" aria-labelledby="descriptiveName-label"><g:fieldValue bean="${DBFieldInstance}" field="descriptiveName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${DBFieldInstance?.fieldNullable}">
				<li class="fieldcontain">
					<span id="fieldNullable-label" class="property-label"><g:message code="DBField.fieldNullable.label" default="Field Nullable" /></span>
					
						<span class="property-value" aria-labelledby="fieldNullable-label"><g:formatBoolean boolean="${DBFieldInstance?.fieldNullable}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${DBFieldInstance?.fieldType}">
				<li class="fieldcontain">
					<span id="fieldType-label" class="property-label"><g:message code="DBField.fieldType.label" default="Field Type" /></span>
					
						<span class="property-value" aria-labelledby="fieldType-label"><g:fieldValue bean="${DBFieldInstance}" field="fieldType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${DBFieldInstance?.isCollection}">
				<li class="fieldcontain">
					<span id="isCollection-label" class="property-label"><g:message code="DBField.isCollection.label" default="Is Collection" /></span>
					
						<span class="property-value" aria-labelledby="isCollection-label"><g:formatBoolean boolean="${DBFieldInstance?.isCollection}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${DBFieldInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="DBField.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${DBFieldInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:DBFieldInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
                                        <g:if test="!DBFieldInstance.pluginField">
                                            <g:link class="edit" action="edit" resource="${DBFieldInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                                        </g:if>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
