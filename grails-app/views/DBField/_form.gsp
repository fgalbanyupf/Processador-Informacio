<%@ page import="com.ratzia.pfc.webpageanalyticaltool.DBField" %>



<div class="fieldcontain ${hasErrors(bean: DBFieldInstance, field: 'fieldName', 'error')} ">
	<label for="fieldName">
		<g:message code="DBField.fieldName.label" default="Field Name" />
		
	</label>
	<g:textField name="fieldName"  pattern="[A-Za-z_]+" maxlength="50" value="${DBFieldInstance?.fieldName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: DBFieldInstance, field: 'plugin', 'error')} ">
	<label for="plugin">
		<g:message code="DBField.plugin.label" default="Plugin" />
		
	</label>
	<g:select id="plugin" name="plugin.id" from="${com.ratzia.pfc.webpageanalyticaltool.DBPlugin.list()}" optionKey="id" value="${DBFieldInstance?.plugin?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: DBFieldInstance, field: 'descriptiveName', 'error')} ">
	<label for="descriptiveName">
		<g:message code="DBField.descriptiveName.label" default="Descriptive Name" />
		
	</label>
	<g:textField name="descriptiveName" value="${DBFieldInstance?.descriptiveName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: DBFieldInstance, field: 'fieldNullable', 'error')} ">
	<label for="fieldNullable">
		<g:message code="DBField.fieldNullable.label" default="Field Nullable" />
		
	</label>
	<g:checkBox name="fieldNullable" value="${DBFieldInstance?.fieldNullable}" />

</div>

<div class="fieldcontain ${hasErrors(bean: DBFieldInstance, field: 'fieldType', 'error')} required">
	<label for="fieldType">
		<g:message code="DBField.fieldType.label" default="Field Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="fieldType" from="${com.ratzia.pfc.webpageanalyticaltool.DBFieldType?.values()}" keys="${com.ratzia.pfc.webpageanalyticaltool.DBFieldType.values()*.name()}" required="" value="${DBFieldInstance?.fieldType?.name()}" />

</div>

<div class="fieldcontain ${hasErrors(bean: DBFieldInstance, field: 'isCollection', 'error')} ">
	<label for="isCollection">
		<g:message code="DBField.isCollection.label" default="Is Collection" />
		
	</label>
	<g:checkBox name="isCollection" value="${DBFieldInstance?.isCollection}" />

</div>

