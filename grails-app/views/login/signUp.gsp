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
  <div id="messages">
  </div>
    <div id="form" class="container">
      <form class="form-signin" role="form" action="Login/signUp" method="POST" id="registerForm">
        <h2 class="form-signin-heading">Accede al chat</h2>
        <label>Username</label><input class="form-control" placeholder="Nombre de usuario" name="username" required="" autofocus="" type="text">
        <label>Correo Electr&oacute;nico</label><input class="form-control" placeholder="Nombre de usuario" name="email" required="" autofocus="" type="text">
        <label>Contrase&ntilde;a</label><input class="form-control" placeholder="Password" id="pass" name="password" required="" type="password">        
        <label>Verifica</label><input class="form-control" placeholder="Password" id="verPass" name="password" required="" type="password">        
        <button id="submitButton" class="btn btn-lg btn-primary btn-block" type="submit" disabled="true">Registrate</button>
      </form>      
    </div>
    <script>
      $(document).ready(function(){
        alert("OK");
      });
      $(document).on("keyup","#verPass",function(evt){
        evt.preventDefault();        
        if($("#pass").val() != $("#verPass").val()){
          $("#messages").html("Verifica las contraseñas tienen que ser iguales");         
          $("#submitButton").attribute("disabled");
        } else {
          $("#submitButton").removeAttr('disabled');          
        }
      });
    </script>
  </body>
</html>
