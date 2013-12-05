package pepo.escom.aplicacionesRed.controllers

class ChatController {

    def index() { }
    def getLastChatContent(){
        ChatContent lastContent = ChatContent.findAll("from ChatContent chat where chat.");
    }
}
