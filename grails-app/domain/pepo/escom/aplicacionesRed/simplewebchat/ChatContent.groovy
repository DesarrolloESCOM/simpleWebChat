package pepo.escom.aplicacionesRed.simplewebchat

class ChatContent {
    Long idChatContent
    Date createdDate
    Long idUser
    String content
    static constraints = {
        idChatContent(nullable:true, blank:true)        
        createdDate(nullable:true, blank:true)
        idUser(nullable:false,blank:false)
        content(blank:false)
    }
    static mapping = {
        version false
        table 'ChatContent'
        id(name:'idChatContent',column:'idChatContent')
        createdDate(column:'createdDate')
        idUser(column:'idUser')
        content(column:'content')        
    }
}
