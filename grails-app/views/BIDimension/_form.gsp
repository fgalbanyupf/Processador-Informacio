<%@ page import="com.ratzia.pfc.webpageanalyticaltool.BIDimension" %>



<div class="fieldcontain ${hasErrors(bean: BIDimensionInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="BIDimension.name.label" default="Name" />
		
	</label>
	<g:textField name="name" maxlength="50" value="${BIDimensionInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: BIDimensionInstance, field: 'fields', 'error')} ">
	<label for="fields">
		<g:message code="BIDimension.fields.label" default="Fields" />
		
	</label>
	<g:select name="fields" from="${com.ratzia.pfc.webpageanalyticaltool.DBField.findAllNotIsCollection()}" multiple="multiple" optionKey="id" size="5" value="${BIDimensionInstance?.fields*.id}" class="one-to-many"/>

</div>

