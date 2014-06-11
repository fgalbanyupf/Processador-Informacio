<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title></title>
		<style type="text/css" media="screen">
			#page-body {
				margin: 2em 2em 1.25em 2em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
		<div id="page-body" role="main">
			<h1><g:message code="application.title"/></h1>
			<p style="text-align:justify"><g:message code="application.introText"/> <br/><br/>

                        <b><g:message code="application.dbTools.label" default="Database definition" /></b><br/>
                        <g:link controller="DBField"><g:message code="DBField.label" default="Database Field" /></g:link> | 
                        <g:link controller="DBPlugin"><g:message code="DBPlugin.label" default="Database Plugin" /></g:link> 
                        <br/>
                        <b><g:message code="application.biTools.label" default="Business Intelligence" /></b><br/>
                        <g:link controller="BIDimension"><g:message code="BIDimension.label" default="Dimension" /></g:link> | 
                        <g:link controller="BIMeasure"><g:message code="BIMeasure.label" default="Measure" /></g:link> |
                        <g:link controller="BISchemaTemplate"><g:message code="BISchemaTemplate.label" default="Schema Template" /></g:link> | 
                        <b><a href="${grailsApplication.config.bisystem.link}"><g:message code="application.accessSaiku.label" default="Go to Saiku" /></a></b>
                        <br/>
                        <b><g:message code="application.crawlerTools.label" default="Web crawling" /></b><br/>
                        <g:link controller="crawlerSession"><g:message code="crawlerSession.label" default="Crawler Session" /></g:link>
                        </p>
		</div>
	</body>
</html>
