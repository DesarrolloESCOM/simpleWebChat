package pepo.escom.aplicacionesRed.controllers

import pepo.escom.aplicacionesRed.simplewebchat.ChatContent
import grails.converters.JSON
class ChatController {
    def ChatService
    def index() {
        render(view:"index")
        return
    }
    def getLastChatContent(){
        println "entre aqui magicamente???"
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
    def getfileLog(){
        /*def lastContent = ChatService.getPrettyFileLog()        
        render([fileResponse:lastContent] as JSON)*/
    }
    def mainChat(){
        render(view: "mainChat", model: [message: "OK"])
        //render(view:"mainChat")
        return
        //render(view:"mainChat")
    }
}
