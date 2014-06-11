
<%@ page import="com.ratzia.pfc.webpageanalyticaltool.CrawlerSession" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'crawlerSession.label', default: 'CrawlerSession')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-crawlerSession" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-crawlerSession" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
                        <p class="domainDescription"><g:message code="crawlerSession.description"/></p>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="seed" title="${message(code: 'crawlerSession.seed.label', default: 'Seed')}" />
					
						<g:sortableColumn property="numCrawlers" title="${message(code: 'crawlerSession.numCrawlers.label', default: 'Num Crawlers')}" />
					
						<g:sortableColumn property="depth" title="${message(code: 'crawlerSession.depth.label', default: 'Depth')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'crawlerSession.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="jail" title="${message(code: 'crawlerSession.jail.label', default: 'Jail')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${crawlerSessionInstanceList}" status="i" var="crawlerSessionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${crawlerSessionInstance.id}" class="urlWidth">${fieldValue(bean: crawlerSessionInstance, field: "seed")}</g:link></td>
					
						<td>${fieldValue(bean: crawlerSessionInstance, field: "numCrawlers")}</td>
					
						<td>${fieldValue(bean: crawlerSessionInstance, field: "depth")}</td>
					
						<td><g:formatDate date="${crawlerSessionInstance.dateCreated}" /></td>
					
						<td>${fieldValue(bean: crawlerSessionInstance, field: "jail")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${crawlerSessionInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
