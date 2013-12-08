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
        String nombreOriginal = f.getOriginalFilename()
        def splittedName = (nombreOriginal).split("\\.");
        String nombreArchivo = "${params.idUser}"+"_"+"${format.format(now)}"+"_"+f.getOriginalFilename()
        nombreArchivo = nombreArchivo.encodeAsMD5();
        int maximo = (nombreArchivo.length() > 200) ? 195 : nombreArchivo.length();
        nombreArchivo = nombreArchivo.substring(0,maximo)+"."+splittedName[splittedName.size()-1];
        String ruta = servletContext.getRealPath('files/')
        //Se almacena el archivo
        f.transferTo(new File(ruta+"/"+nombreArchivo))
        //se guarda en la base
        SimpleFile file = new SimpleFile()
        file.type = f.contentType
        file.nameOfFile = nombreArchivo 

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
            render("Archivo subido exitosamente ");
            return
        }catch(Exception e){
            //response(e.getLocalizedMessage())
            render("Ocurrio un error intente m&aacute;s tarde");
            return
        }                
    }
    def getfileLog(){
        def lastContent = ChatService.getPrettyFileLog()
        if(lastContent.size()>0){
            render([fileResponse:lastContent] as JSON)
            return
        } else {
            response.status = 404;
            render("Ups, a&uacute;n no hay archivos!")
            return
        }

    }
    def mainChat(){
        render(view: "mainChat", model: [message: "OK"])
        return
    }
    def getTypeOfFile(){
        SimpleFile simple = SimpleFile.findByNameOfFile(params?.nameOfFile)
        String type = simple.type
        render(type)        
    }
}
