<%@ page import="com.ratzia.pfc.webpageanalyticaltool.DBPlugin" %>


<div class="fieldcontain ${hasErrors(bean: DBPluginInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="DBPlugin.name.label" default="Name" />
		
	</label>
	<g:textField id="pluginName" name="name" value="${DBPluginInstance?.name}"/>

</div>

<!--<div class="fieldcontain ${hasErrors(bean: DBPluginInstance, field: 'fields', 'error')} ">
	<label for="fields">
		<g:message code="DBPlugin.fields.label" default="Fields" />
		
	</label>
	<g:select name="fields" from="${com.ratzia.pfc.webpageanalyticaltool.DBField.list()}" multiple="multiple" optionKey="id" size="5" value="${DBPluginInstance?.fields*.id}" class="many-to-many"/>

</div>-->

<div class="fieldcontain ${hasErrors(bean: DBPluginInstance, field: 'enabled', 'error')} ">
	<label for="enabled">
		<g:message code="DBPlugin.enabled.label" default="Enabled" />
		
	</label>
	<g:checkBox name="enabled" value="${DBPluginInstance?.enabled}" />

</div>

<div class="fieldcontain ${hasErrors(bean: DBPluginInstance, field: 'code', 'error')} required">
        <g:message code="DBPlugin.code.label" default="Code" />
	<span class="required-indicator">*</span>
	
        
        <g:textArea id="code_textarea"  style="display:none" name="code" cols="40" rows="5" maxlength="50000" required="" value="${DBPluginInstance?.code}"/> 
        <pre id="editor" style="height: 600px;">
<g:if test="${DBPluginInstance?.code != null}">            
${DBPluginInstance?.code}
</g:if>
<g:else>
package com.ratzia.pfc.webpageanalyticaltool.dbupdater

/**
 *
 * @author ...
 */
 
// Biblioteca inclosa per tractament del llenguatge 
//import com.carrotsearch.labs.langid.DetectedLanguage
//import com.carrotsearch.labs.langid.LangIdV3

// Biblioteca inclosa per al tractament d'HTML
//import org.jsoup.Jsoup 

// Es poden fer servir les biblioteques estàndard de java, per exemple:
//import java.net.InetAddress;

import com.mongodb.DBObject;
public class *CLASSNAME* extends SysPlugin {
    *ATRIBUTS*
    //Constructor per defecte
    public *CLASSNAME*(){
        *OMPLE'M*
    }

    //Mètode cridat per cada registre
    public void run(DBObject obj){
        //Es pot modificar la instància obj ampliant camps nous
        //Tots els camps addicionals han de començar per p_
        //Les modificacions als camps bàsics no es mantenen
        *OMPLE'M*
    }
}
</g:else>
        </pre>
        <script src="${createLink(uri: '/js/ace-min/ace.js')}" type="text/javascript" charset="utf-8"></script>
        <script>
            
            String.prototype.capitalize = function() {
                return this.replace(/(?:^|\s)\S/g, function(a) { return a.toUpperCase(); });
            };
            
            var editor = ace.edit("editor");
            editor.setTheme("ace/theme/crimson_editor");
            editor.getSession().setMode("ace/mode/groovy");
            
            var textarea = $('#code_textarea');
            editor.getSession().on('change', function () {
                textarea.val(editor.getSession().getValue());
            });

            textarea.val(editor.getSession().getValue());
            var oldName=$('#pluginName').val();
            try{
                oldName = oldName.capitalize().replace(new RegExp(" ", 'g'), "");
                if(oldName.length == 0) oldName = "*CLASSNAME*";
            }catch(e){
                oldName = "*CLASSNAME*";
            }
            
            var pluginName = $('#pluginName').on('change', function () {
                var name=$('#pluginName').val()
                if(name.length>0){
                    name = name.capitalize().replace(new RegExp(" ", 'g'), "");
                    editor.find("public class " + oldName,{
                        backwards: false,
                        wrap: false,
                        caseSensitive: false,
                        wholeWord: false,
                        regExp: false
                     });
                    editor.replaceAll("public class " + name);
                    editor.replaceAll("public " + name);
                    oldName = name;
                }
            });
            
        </script> 
    </div>