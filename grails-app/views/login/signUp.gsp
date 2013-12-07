<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <meta name="layout" content="main"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registrate al Chat masivo de la ESCOM!</title>
  </head>
  <body class="mainWindow">    
    <g:if test='${flash.message}'>
      <div class='alert alert-danger'><h3><center>${flash.message}</center></h3></div>
    </g:if>    
    <div id="form" class="container">
      <form class="form-signin" role="form" action="Login/login" method="POST">
        <h2 class="form-signin-heading">Accede al chat</h2>
        <label>Username</label><input class="form-control" placeholder="Nombre de usuario" name="username" required="" autofocus="" type="text">
        <label>Correo Electr&oacute;nico</label><input class="form-control" placeholder="Nombre de usuario" name="email" required="" autofocus="" type="text">
        <label>Contrase&ntilde;a</label><input class="form-control" placeholder="Password" id="pass" name="password" required="" type="password">        
        <label>Verifica</label><input class="form-control" placeholder="Password" id="verPass" name="password" required="" type="password">        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Accede</button>
      </form>
      <form action="Login/signUp" method="POST">
        <button class="btn btn-link" type="submit">¿A&uacute;n no eres miembro? &Uacute;nete! Registrate aqu&iacute;!</button>
      </form>      
    </div>    
  </body>
</html>
