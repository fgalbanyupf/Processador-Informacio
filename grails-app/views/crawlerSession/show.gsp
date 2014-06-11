
<%@ page import="com.ratzia.pfc.webpageanalyticaltool.CrawlerSession" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'crawlerSession.label', default: 'CrawlerSession')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
                
                <script>
                    function updateCrawlerStatus(){
                        var url = "${createLink(controller:'crawlerSession', action:'ajaxCrawlerStatus')}/${crawlerSessionInstance?.id}"
                        $('#ajaxCrawlerSpinner').fadeIn();
                        var jqxhr = $.getJSON( url, function(data) {
                            $('#statusContainer').html(data.status)
                            $('#ajaxCrawlerSpinner').fadeOut();
                        })
                        .always(function() {
                              setTimeout(updateCrawlerStatus,2000); //2s.
                        });
                    }
                    $(document).ready(updateCrawlerStatus);
                    
                </script>
	</head>
	<body>
		<a href="#show-crawlerSession" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-crawlerSession" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list crawlerSession">
			
				<g:if test="${crawlerSessionInstance?.seed}">
				<li class="fieldcontain">
					<span id="seed-label" class="property-label"><g:message code="crawlerSession.seed.label" default="Seed" /></span>
					
						<span class="property-value" aria-labelledby="seed-label"><g:fieldValue bean="${crawlerSessionInstance}" field="seed"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${crawlerSessionInstance?.numCrawlers}">
				<li class="fieldcontain">
					<span id="numCrawlers-label" class="property-label"><g:message code="crawlerSession.numCrawlers.label" default="Num Crawlers" /></span>
					
						<span class="property-value" aria-labelledby="numCrawlers-label"><g:fieldValue bean="${crawlerSessionInstance}" field="numCrawlers"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${crawlerSessionInstance?.depth}">
				<li class="fieldcontain">
					<span id="depth-label" class="property-label"><g:message code="crawlerSession.depth.label" default="Depth" /></span>
					
						<span class="property-value" aria-labelledby="depth-label"><g:fieldValue bean="${crawlerSessionInstance}" field="depth"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${crawlerSessionInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="crawlerSession.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${crawlerSessionInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${crawlerSessionInstance?.jail}">
				<li class="fieldcontain">
					<span id="jail-label" class="property-label"><g:message code="crawlerSession.jail.label" default="Jail" /></span>
					
						<span class="property-value" aria-labelledby="jail-label"><g:fieldValue bean="${crawlerSessionInstance}" field="jail"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${crawlerSessionInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="crawlerSession.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${crawlerSessionInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
                                
				<li class="fieldcontain" style="position:relative">
                                    <span class="property-label"><b>Status</b></span>
					
						<span id="statusContainer" class="property-value" >${crawlerSessionInstance?.status}</span><img id="ajaxCrawlerSpinner" style="position:absolute;top:0px;left:80px;" src="${resource(dir:'images',file:'spinner_arr_whitebg.gif')}" alt="${message(code:'spinner.alt',default:'Loading...')}" />
					
				</li>
                                <g:if test="${crawlerSessionInstance?.running}">
                                <li class="fieldcontain">    
                                    <ul>
                                        <li><g:link class="edit" action="stop" resource="${crawlerSessionInstance}"><g:message code="crawlerSession.stop.label" default="Stop" /></g:link></li>
                                    </ul>
                                </li>
                                </g:if>
			</ol>
                        
                        
                        
                        
                            
                        
                        
			<g:form url="[resource:crawlerSessionInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<!--<g:link class="edit" action="edit" resource="${crawlerSessionInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>-->
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
