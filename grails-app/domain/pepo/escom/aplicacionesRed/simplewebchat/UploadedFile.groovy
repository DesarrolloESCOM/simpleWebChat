package pepo.escom.aplicacionesRed.simplewebchat

class UploadedFile {
    Long idUploadedFile
    Long idUser
    Long idFile
    Date createdDate
    static constraints = {
        idUploadedFile(nullable:true, blank:true)        
        idUser(nullable:false, blank:false)
        idFile(nullable:false, blank:false)
        createdDate(blank:false, size:0..500)        
    }
    static mapping = {
        version false
        table 'UploadedFile'
        id(name:'idUploadedFile',column:'idUploadedFile')
        idUser(column:'idUser')
        idFile(column:'idFile')
        createdDate(column:'createdDate')        
    }
}
