
<%@ page import="com.ratzia.pfc.webpageanalyticaltool.BIMeasure" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'BIMeasure.label', default: 'BIMeasure')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-BIMeasure" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-BIMeasure" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list BIMeasure">
			
				<g:if test="${BIMeasureInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="BIMeasure.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${BIMeasureInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${BIMeasureInstance?.aggregator}">
				<li class="fieldcontain">
					<span id="aggregator-label" class="property-label"><g:message code="BIMeasure.aggregator.label" default="Aggregator" /></span>
					
						<span class="property-value" aria-labelledby="aggregator-label"><g:fieldValue bean="${BIMeasureInstance}" field="aggregator"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${BIMeasureInstance?.field}">
				<li class="fieldcontain">
					<span id="field-label" class="property-label"><g:message code="BIMeasure.field.label" default="Field" /></span>
					
						<span class="property-value" aria-labelledby="field-label"><g:link controller="DBField" action="show" id="${BIMeasureInstance?.field?.id}">${BIMeasureInstance?.field?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${BIMeasureInstance?.visible}">
				<li class="fieldcontain">
					<span id="visible-label" class="property-label"><g:message code="BIMeasure.visible.label" default="Visible" /></span>
					
						<span class="property-value" aria-labelledby="visible-label"><g:formatBoolean boolean="${BIMeasureInstance?.visible}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:BIMeasureInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${BIMeasureInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
