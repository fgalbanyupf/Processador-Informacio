
<%@ page import="com.ratzia.pfc.webpageanalyticaltool.BISchemaTemplate" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'BISchemaTemplate.label', default: 'BISchemaTemplate')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-BISchemaTemplate" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-BISchemaTemplate" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
                        <p class="domainDescription"><g:message code="BISchemaTemplate.description"/></p>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'BISchemaTemplate.name.label', default: 'Name')}" />
					
						<!--<g:sortableColumn property="code" title="${message(code: 'BISchemaTemplate.code.label', default: 'Code')}" />
					
						<g:sortableColumn property="enabled" title="${message(code: 'BISchemaTemplate.enabled.label', default: 'Enabled')}" />-->
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${BISchemaTemplateInstanceList}" status="i" var="BISchemaTemplateInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${BISchemaTemplateInstance.id}">${fieldValue(bean: BISchemaTemplateInstance, field: "name")}</g:link></td>
					
						<!--<td>${fieldValue(bean: BISchemaTemplateInstance, field: "code")}</td>
					
						<td><g:formatBoolean boolean="${BISchemaTemplateInstance.enabled}" /></td>-->
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${BISchemaTemplateInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
