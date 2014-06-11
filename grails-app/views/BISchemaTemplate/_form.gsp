<%@ page import="com.ratzia.pfc.webpageanalyticaltool.BISchemaTemplate" %>



<div class="fieldcontain ${hasErrors(bean: BISchemaTemplateInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="BISchemaTemplate.name.label" default="Name" />
		
	</label>
	<g:textField name="name" maxlength="50" value="${BISchemaTemplateInstance?.name}"/>

</div>
<!--
<div class="fieldcontain ${hasErrors(bean: BISchemaTemplateInstance, field: 'code', 'error')} required">
	<label for="code">
		<g:message code="BISchemaTemplate.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="code" cols="40" rows="5" maxlength="50000" required="" value="${BISchemaTemplateInstance?.code}"/>

</div>
-->
<!--<div class="fieldcontain ${hasErrors(bean: BISchemaTemplateInstance, field: 'enabled', 'error')} ">
	<label for="enabled">
		<g:message code="BISchemaTemplate.enabled.label" default="Enabled" />
		
	</label>
	<g:checkBox name="enabled" value="${BISchemaTemplateInstance?.enabled}" />

</div>-->


<div class="fieldcontain ${hasErrors(bean: BISchemaTemplateInstance, field: 'code', 'error')} required">
        <g:message code="BISchemaTemplateInstance.code.label" default="Code" />
	<span class="required-indicator">*</span>
	
        
        <g:textArea id="code_textarea"  style="display:none" name="code" cols="40" rows="5" maxlength="50000" required="" value="${BISchemaTemplateInstance?.code}"/> 
        <pre id="editor" style="height: 600px;">
<g:if test="${BISchemaTemplateInstance?.code != null}">            
${BISchemaTemplateInstance?.code}
</g:if>
</pre>
<script>    
    
</script>
        <script src="${createLink(uri: '/js/ace-min/ace.js')}" type="text/javascript" charset="utf-8"></script>
        <script>
            //http://stackoverflow.com/questions/6507293/convert-xml-to-string-with-jquery
            function xmlToString(xmlData) { 

                var xmlString;
                //IE
                if (window.ActiveXObject){
                    xmlString = xmlData.xml;
                }
                // code for Mozilla, Firefox, Opera, etc.
                else{
                    xmlString = (new XMLSerializer()).serializeToString(xmlData);
                }
                return xmlString;
            } 
            String.prototype.capitalize = function() {
                return this.replace(/(?:^|\s)\S/g, function(a) { return a.toUpperCase(); });
            };
            
            var editor = ace.edit("editor");
            editor.setTheme("ace/theme/crimson_editor");
            editor.getSession().setMode("ace/mode/xml");
            
            var textarea = $('#code_textarea');
            editor.getSession().on('change', function () {
                textarea.val(editor.getSession().getValue());
            });

            textarea.val(editor.getSession().getValue());
            
            <g:if test="${BISchemaTemplateInstance?.code == null}">            
                
            $.get("${createLink(uri: '/resources/bi_base_schema.xml')}", 
                function(data) {
                    editor.getSession().setValue(xmlToString(data));
                }
            );
            </g:if>
            
        </script> 
    </div>