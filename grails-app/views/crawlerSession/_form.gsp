<%@ page import="com.ratzia.pfc.webpageanalyticaltool.CrawlerSession" %>



<div class="fieldcontain ${hasErrors(bean: crawlerSessionInstance, field: 'seed', 'error')} ">
	<label for="seed">
		<g:message code="crawlerSession.seed.label" default="Seed" />
		
	</label>
	<g:textField name="seed" maxlength="100" value="${crawlerSessionInstance?.seed}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: crawlerSessionInstance, field: 'numCrawlers', 'error')} required">
	<label for="numCrawlers">
		<g:message code="crawlerSession.numCrawlers.label" default="Num Crawlers" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="numCrawlers" type="number" value="${crawlerSessionInstance.numCrawlers}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: crawlerSessionInstance, field: 'depth', 'error')} required">
	<label for="depth">
		<g:message code="crawlerSession.depth.label" default="Depth" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="depth" type="number" value="${crawlerSessionInstance.depth}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: crawlerSessionInstance, field: 'jail', 'error')} ">
	<label for="jail">
		<g:message code="crawlerSession.jail.label" default="Jail" />
		
	</label>
	<g:textField name="jail" value="${crawlerSessionInstance?.jail}"/>
        <i><g:message code="crawlerSession.jail.hint.label" default="Regular Expression" /></i>
        <div style="margin-left:200px">
            <b><g:message code="crawlerSession.jail.examples.label" default="Examples" /></b>
            <ul>
                <li><g:message code="crawlerSession.jail.examples.any" default="Follow all links" /> <i>.*</i></li>
                <li><g:message code="crawlerSession.jail.examples.upf" default="Follow all webpages in upf.edu including subdomains" /> <i>https?://[^\\.]*.upf.edu|https?://[^\\.]*.upf.edu/?.*</i></li>
                <li><g:message code="crawlerSession.jail.examples.cat" default="Follow all webpages in cat TLD" /> <i>https?://[^\\/]+.cat|https?://[^\\/]+.cat/.*</i></li>
            </ul>
        </div>
</div>

