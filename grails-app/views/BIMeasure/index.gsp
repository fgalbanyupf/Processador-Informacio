
<%@ page import="com.ratzia.pfc.webpageanalyticaltool.BIMeasure" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'BIMeasure.label', default: 'BIMeasure')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-BIMeasure" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-BIMeasure" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
                        <p class="domainDescription"><g:message code="BIMeasure.description"/></p>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'BIMeasure.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="aggregator" title="${message(code: 'BIMeasure.aggregator.label', default: 'Aggregator')}" />
					
						<th><g:message code="BIMeasure.field.label" default="Field" /></th>
					
						<g:sortableColumn property="visible" title="${message(code: 'BIMeasure.visible.label', default: 'Visible')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${BIMeasureInstanceList}" status="i" var="BIMeasureInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${BIMeasureInstance.id}">${fieldValue(bean: BIMeasureInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: BIMeasureInstance, field: "aggregator")}</td>
					
						<td>${fieldValue(bean: BIMeasureInstance, field: "field")}</td>
					
						<td><g:formatBoolean boolean="${BIMeasureInstance.visible}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${BIMeasureInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
