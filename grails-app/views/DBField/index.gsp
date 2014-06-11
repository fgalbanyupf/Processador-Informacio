
<%@ page import="com.ratzia.pfc.webpageanalyticaltool.DBField" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'DBField.label', default: 'DBField')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-DBField" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-DBField" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
                        <p class="domainDescription"><g:message code="DBField.description"/></p>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="fieldName" title="${message(code: 'DBField.fieldName.label', default: 'Field Name')}" />
					
						<th><g:message code="DBField.plugin.label" default="Plugin" /></th>
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'DBField.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="descriptiveName" title="${message(code: 'DBField.descriptiveName.label', default: 'Descriptive Name')}" />
					
						<g:sortableColumn property="fieldNullable" title="${message(code: 'DBField.fieldNullable.label', default: 'Field Nullable')}" />
					
						<g:sortableColumn property="fieldType" title="${message(code: 'DBField.fieldType.label', default: 'Field Type')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${DBFieldInstanceList}" status="i" var="DBFieldInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${DBFieldInstance.id}">${fieldValue(bean: DBFieldInstance, field: "fieldName")}</g:link></td>
					
						<td>${fieldValue(bean: DBFieldInstance, field: "plugin")}</td>
					
						<td><g:formatDate date="${DBFieldInstance.dateCreated}" /></td>
					
						<td>${fieldValue(bean: DBFieldInstance, field: "descriptiveName")}</td>
					
						<td><g:formatBoolean boolean="${DBFieldInstance.fieldNullable}" /></td>
					
						<td>${fieldValue(bean: DBFieldInstance, field: "fieldType")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${DBFieldInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
