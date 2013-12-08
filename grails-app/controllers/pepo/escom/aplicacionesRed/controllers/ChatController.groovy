package pepo.escom.aplicacionesRed.controllers

import pepo.escom.aplicacionesRed.simplewebchat.ChatContent
import grails.converters.JSON
import java.text.SimpleDateFormat
import pepo.escom.aplicacionesRed.simplewebchat.SimpleFile
import pepo.escom.aplicacionesRed.simplewebchat.UploadedFile
class ChatController {
    def ChatService
    def index() {
        render(view:"index")
        return
    }
    def getLastChatContent(){        
        def lastContent = ChatService.getPrettyChatLines()        
        render([response:lastContent] as JSON)
        return
    }
    def addLineToChat(){
        ChatContent newLine = new ChatContent(params)
        try{
            newLine.save(flush:true,failOnError:true)
        }catch(Exception e){
            render([message:e.getLocalizedMessage()] as JSON)
        }   
    }
    def upload() {
        Date now = new Date()
        SimpleDateFormat format =  new SimpleDateFormat("dd-MM-yyyy")
        def f = request.getFile('file')
        if (f.empty) {            
            render("El archivo no puede ser vacio!")
            return
        }
        String nombreArchivo = "${params.idUser}"+"_"+"${format.format(now)}"+"_"+f.getOriginalFilename()
        String ruta = servletContext.getRealPath('files/')
        println("RUTA "+ruta);
        //Se almacena el archivo
        f.transferTo(new File(ruta+"/"+nombreArchivo))
        //se guarda en la base
        SimpleFile file = new SimpleFile()
        file.nameOfFile = nombreArchivo
        file.type = f.contentType
        try{
            file.save(flush:true,failOnError:true)//
            //Se guarda el objeto, por lo que se obtiene su persistente
            UploadedFile uploaded = new UploadedFile();
            uploaded.idUser = Integer.parseInt(params.idUser)
            uploaded.idFile = file.idFile
            uploaded.createdDate = now;
            uploaded.save(flush:true,failOnError:true)
            ChatContent fileLine = new ChatContent()
            fileLine.idUser = Long.parseLong(params.idUser)
            fileLine.content = "Ha subido el archivo <b><i>"+file.nameOfFile+"</i></b>"
            fileLine.save(flush:true,failOnError:true)
            response.sendError(200, 'Done') 
            render("Archivo subido exitosamente ");
        }catch(Exception e){
            //response(e.getLocalizedMessage())
            render("Ocurrio un error intente m&aacute;s tarde");
        }                
    }
    def getfileLog(){
        def lastContent = ChatService.getPrettyFileLog()                
        render([fileResponse:lastContent] as JSON)
    }
    def mainChat(){
        render(view: "mainChat", model: [message: "OK"])
        //render(view:"mainChat")
        return
        //render(view:"mainChat")
    }
}
