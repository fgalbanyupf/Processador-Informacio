<%@ page import="com.ratzia.pfc.webpageanalyticaltool.BackgroundProcessStatus" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:message code="application.title"/> - <g:layoutTitle default=""/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
		<!-- <g:javascript library="application"/>	-->
                <g:javascript library="jquery" plugin="jquery"/>
		<r:layoutResources />
                <g:layoutHead/>
                <script>
                    function ajaxCallIgnoreReturn(URL){
                        //console.log(URL);
                        $.ajax({url: URL});
                    }
                    function updateStatus(){
                        var RUNNINGSTATE="${BackgroundProcessStatus.RUNNING}"
                        var STOPPEDSTATE="${BackgroundProcessStatus.STOPPED}"
                        var IDLESTATE="${BackgroundProcessStatus.IDLE}"
                        var baseLink = "${createLink(controller:'crawlerSession', action:'show')}/"
                        
                        var play="&rtrif;" 
                        var stop="&FilledSmallSquare;"
                        var startAjaxCall="${createLink(controller:'SystemStatus', action:'startProcess')}/"
                        var stopAjaxCall="${createLink(controller:'SystemStatus', action:'stopProcess')}/"
                        $('#ajaxSpinner').fadeIn();
                        var jqxhr = $.getJSON( "${createLink(controller:'SystemStatus', action:'processesStatus')}", function(data) {
                            var backgroundProcesses = data.backgroundProcesses
                            var crawlerSessions = data.crawlerSessions
                            $('#statusProcessesContent').empty()
                            for(i=0; i<backgroundProcesses.length;i++){
                                var elem = $('<li>').html(backgroundProcesses[i][0] + " <i>" + backgroundProcesses[i][1] + "</i>");
                                if(backgroundProcesses[i][1] == RUNNINGSTATE){
                                    elem.append('&nbsp;<img src="${resource(dir:'images',file:'running.gif')}"/>')
                                }else if(backgroundProcesses[i][1] == STOPPEDSTATE){
                                    clickable = $('<span>').css('cursor','pointer').html(play)
                                    elem.append(' ')
                                    elem.append(clickable)
                                    clickable.data( "processType", backgroundProcesses[i][2] );
                                    clickable.click(
                                        function(){
                                            //var bptype=backgroundProcesses[i][2]
                                            ajaxCallIgnoreReturn(startAjaxCall + $(this).data( "processType"))
                                        }
                                    )
                                }else if(backgroundProcesses[i][1] == IDLESTATE){
                                    clickable = $('<span>').css('cursor','pointer').html(stop)
                                    elem.append(' ')
                                    elem.append(clickable)
                                    clickable.data( "processType", backgroundProcesses[i][2] );
                                    clickable.click(
                                        function(){
                                            ajaxCallIgnoreReturn(stopAjaxCall + $(this).data( "processType"))
                                        }
                                    )
                                }
                                $('#statusProcessesContent').append(elem)
                            }
                            
                            $('#statusCrawlersContent').empty()
                            for(i=0; i<crawlerSessions.length;i++){
                                htmlText = '<a href="' + baseLink+crawlerSessions[i][0] + '"><img src="${resource(dir:'images',file:'running.gif')}"/>&nbsp;' + crawlerSessions[i][1] + '</a>';
                                $('#statusCrawlersContent').append($('<li>').html(htmlText))
                            }
                            $('#ajaxSpinner').fadeOut();
                        })
                        .always(function() {
                              setTimeout(updateStatus,2000); //2s.
                        });
                    }
                    $(document).ready(updateStatus);
                    
                </script>
	</head>
	<body>
            <div id="mainLogo" role="banner" style="position:relative;height:130px">
                <sec:ifLoggedIn>
                    
                <!--<a href="http://144.76.200.86:8080">[LOGO]</a>-->
                <div id="toolBar"  style="position:absolute; top:10px; left:25px;width:500px;height:70px">
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
                </div>

                <div id="status" style="position:absolute; top:5px; right:5px;width:500px;height:90px">
                    <div id="statusProcesses" style="position:absolute; top:5px; left:5px;">
                        <b><g:message code="application.backgroundprocesses.label" default="Background Processes" /></b>
                        <ul id="statusProcessesContent">
                        </ul>
                    </div>
                    <div id="statusCrawlers" style="position:absolute; top:5px; right:5px; left:240px; height:80px; overflow:auto">
                        <b><g:message code="application.runningCrawlers.label" default="Running Crawlers" /></b>
                        <ul id="statusCrawlersContent">
                        </ul>
                    </div>
                    <img id="ajaxSpinner" src="${resource(dir:'images',file:'spinner_arr.gif')}" alt="${message(code:'spinner.alt',default:'Loading...')}" />
                </div>
                <div id="toolbarRight" style="position:absolute; top:105px; right:5px;width:500px;height:90px">
                    <g:link controller="SystemStatus" action="launchExpander" params="[targetUri: (request.forwardURI - request.contextPath)]"><g:message code="application.backgroundprocesses.forceDBE.label" default="Force-execute DB Expander" /></g:link>
                </div>
                </sec:ifLoggedIn>
            </div>
            <g:layoutBody/>
            <div class="footer" role="contentinfo"></div>
            <div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
            <r:layoutResources />
	</body>
</html>
