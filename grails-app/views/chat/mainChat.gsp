<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <meta name="layout" content="main"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Simple Web Chat - [IPN-ESCOM]</title>		    
  </head>
  <body class="mainWindow">    
    <div id="dialog-form" title="Subir un nuevo archivo">
      <p class="validateTips">Elige un archivo a subir</p>
      <form action="upload" method="post" id="fileUploader" enctype="multipart/form-data" target="fileResponseReceiver">
        <input type="hidden" value="${session.user.idUser}" name="idUser" id="idUser"/>
        <input type="file" name="file">        
      </form>       
      <center>
        <iframe id="fileResponseReceiver" name="fileResponseReceiver" width="100%" height="100px" scrolling="no" src=""></iframe>
      </center>      
    </div>
    <div id="successBanner" title="Bienvenido ${session.user.username}!">      
    </div>    
    <div class="container" id="mainContent">
      <div id="chat" >
        <div id="chatContent" class="panel panel-primary">
          <div class="panel-heading">
            <h3 class="panel-title">Chat Principal</h3>
          </div>
          <div id="textPanel">
            <div id="chatLog" >            
            </div>
            <div id="textArea">
              <div id="leftPanel">
                <input class="form-control" placeholder="Escribe lo que deseas expresar!" type="text" id="message" width="50%"/>
              </div>
              <div id="rightPanel">
                <button id="sendMessage" class="btn btn-success" disabled="true">Enviar</button>
                <button id="openUploadDialog" class="btn btn-warning">Subir un archivo</button>
                <button id="closeSession" class="btn btn-warning" id="logoutTrigger">Salir</button>
                <form action="../login/logout" method="POST" id="logoutForm">
                <form>                
              </div>
            </div>
          </div>
        </div>
        <div id="info">
          <div class="panel panel-success">
            <div class="panel-heading">
              <h3 class="panel-title">Archivos Recientes</h3>
            </div>            
            <div id="filePanel" class="panel-body">
            </div>            
          </div>
          <div class="panel panel-warning">
            <div class="panel-heading">
              <h3 class="panel-title" id="titleReceiver">Vista Previa</h3>
            </div>
            <div id="preview">
              Arrastra la liga para ver el contenido deseado.
            </div>
            <div id="previewContent"></div>
          </div>
        </div>
      </div> 
    </div>    
  </body>
</html>