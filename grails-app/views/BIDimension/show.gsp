
<%@ page import="com.ratzia.pfc.webpageanalyticaltool.BIDimension" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'BIDimension.label', default: 'BIDimension')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-BIDimension" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-BIDimension" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list BIDimension">
			
				<g:if test="${BIDimensionInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="BIDimension.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${BIDimensionInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${BIDimensionInstance?.fields}">
				<li class="fieldcontain">
					<span id="fields-label" class="property-label"><g:message code="BIDimension.fields.label" default="Fields" /></span>
                                            <table>
						<g:each in="${BIDimensionInstance.fields}" var="f">
                                                    <tr>
                                                        <td><g:link controller="DBField" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></td>
                                                        <td><g:link style="text-decoration:none" action="fieldUp" resource="${BIDimensionInstance}" params="[fieldId:f?.id]">&uarr;</g:link></td>
                                                        <td><g:link style="text-decoration:none" action="fieldDown" resource="${BIDimensionInstance}" params="[fieldId:f?.id]">&darr;</g:link></td>
                                                        <td><g:link style="text-decoration:none" action="removeField" resource="${BIDimensionInstance}" params="[fieldId:f?.id]">[X]</g:link></td>
                                                    </tr>
						</g:each>
                                            </table>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:BIDimensionInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${BIDimensionInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
