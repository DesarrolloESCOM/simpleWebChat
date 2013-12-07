<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <meta name="layout" content="main"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Accede!</title>
  </head>
  <body class="mainWindow">    
    <g:if test='${flash.message}'>
      <div class='alert alert-danger'><h3><center>${flash.message}</center></h3></div>
    </g:if>    
    <div id="form" class="container">
      <form class="form-signin" role="form" action="Login/login" method="POST">
        <h2 class="form-signin-heading">Accede al chat</h2>
        <input class="form-control" placeholder="Nombre de usuario" name="user" required="" autofocus="" type="text">
        <input class="form-control" placeholder="Password" name="password" required="" type="password">        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Accede</button>
      </form>      
      <a class="btn btn-link" href="${createLink(action: 'signUp')}" target="_self">¿A&uacute;n no eres miembro? &Uacute;nete! Registrate aqu&iacute;!</a>
    </div>    
  </body>
</html>
