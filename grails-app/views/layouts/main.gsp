<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">		                                 
                <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.css')}" type="text/css">
                <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap-theme.css')}" type="text/css">
                <link rel="stylesheet" href="${resource(dir: 'css', file: 'jquery-ui-1.10.3.custom.min.css')}" type="text/css">                
                <link rel="stylesheet" href="${resource(dir: 'css', file: 'mainStyles.css')}" type="text/css">
                <script src="${resource(dir: 'js', file: 'jquery1-10-1.js')}" type="text/javascript"></script>
                <script src="${resource(dir: 'js', file: 'jquery-cookie.js')}" type="text/javascript"></script>
                <!--<script src="${resource(dir: 'js', file: 'jquery-ui-1.10.3.custom.min.js')}" type="text/javascript"></script>-->
                <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">                
                <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
                <script src="${resource(dir: 'js', file: 'functions.js')}" type="text/javascript"></script>
		<g:layoutHead/>
		<r:layoutResources />
	</head>
	<body>
          <div class="navbar navbar-default">
            <div class="container">
              <center>          
                <ul class="nav">            
                  <li class="active">
                    <table>
                      <tr>
                        <td><img src="${resource(dir: 'images', file: 'Logo-IPN.png')}" width="20px" height="29px"/></td>
                        <td><a href="#">Instituto Polit&eacute;cnico Nacional  - Escuela Superior de C&oacute;mputo</a></td>
                        <td><img src="${resource(dir: 'images', file: 'escom_normal.png')}" width="29px" height="29px"/></td>
                      </tr>
                    </table>
                  </li>
                </ul>          
              </center>        
            </div>
          </div>
		<g:layoutBody/>
		<div class="footer" role="contentinfo"></div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		<g:javascript library="application"/>
		<r:layoutResources />
	</body>
</html>
