<%@ page import="com.ratzia.pfc.webpageanalyticaltool.BIMeasure" %>



<div class="fieldcontain ${hasErrors(bean: BIMeasureInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="BIMeasure.name.label" default="Name" />
		
	</label>
	<g:textField name="name" maxlength="50" value="${BIMeasureInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: BIMeasureInstance, field: 'aggregator', 'error')} required">
	<label for="aggregator">
		<g:message code="BIMeasure.aggregator.label" default="Aggregator" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="aggregator" from="${com.ratzia.pfc.webpageanalyticaltool.BIAggregator?.values()}" keys="${com.ratzia.pfc.webpageanalyticaltool.BIAggregator.values()*.name()}" required="" value="${BIMeasureInstance?.aggregator?.name()}" />

</div>

<div class="fieldcontain ${hasErrors(bean: BIMeasureInstance, field: 'field', 'error')} required">
	<label for="field">
		<g:message code="BIMeasure.field.label" default="Field" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="field" name="field.id" from="${com.ratzia.pfc.webpageanalyticaltool.DBField.findAllByIsCollection(false)}" optionKey="id" required="" value="${BIMeasureInstance?.field?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: BIMeasureInstance, field: 'visible', 'error')} ">
	<label for="visible">
		<g:message code="BIMeasure.visible.label" default="Visible" />
		
	</label>
	<g:checkBox name="visible" value="${BIMeasureInstance?.visible}" />

</div>

