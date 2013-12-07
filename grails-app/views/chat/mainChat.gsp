<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <meta name="layout" content="main"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Simple Web Chat - [IPN-ESCOM]</title>		
  </head>
  <body class="mainWindow">    
    <div id="successBanner" class="alert alert-success">
      <h3>Bienvenido ${session.user.username}!</h3>
      <small><i>Cerrar</i></small>
    </div>
    <input type="hidden" value="${session.user.idUser}" name="idUser" id="idUser"/>
    <div class="container" id="mainContent">
      <div id="chat" >
        <div id="chatContent" class="panel panel-primary">
          <div class="panel-heading">
            <h3 class="panel-title">Chat Principal</h3>
          </div>
          <div id="textPanel">
            <div id="chatLog" >            
            </div>
            <hr>
            <div id="leftPanel">
              <input class="form-control" placeholder="Escribe lo que deseas expresar!" type="text" id="message"/>
            </div>
            <div id="rightPanel">
              <button id="sendMessage" class="btn btn-success" disabled="true">Enviar</button>
            </div>
          </div>
        </div>
        <div id="info" class="panel panel-primary">
          <div class="panel-heading">
            <h3 class="panel-title">Archivos Recientes</h3>
            <div id="filePanel">
              ¡Ups! No hay archivos a&uacute;n
            </div>
          </div>
        </div>
        <div id="files" class="panel panel-warning">
          <div class="panel-heading">
            <h3 class="panel-title">Vista Previa</h3>
            <div id="preview">
              Arrastra la liga para ver el contenido deseado.
            </div>
          </div>
        </div>      
      </div> 
    </div>
  </body>
</html>