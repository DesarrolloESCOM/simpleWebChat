package pepo.escom.aplicacionesRed.simplewebchat

class SimpleFile {
    Long idFile    
    String nameOfFile
    String type
    static constraints = {
        idFile(nullable:true, blank:true)        
        nameOfFile(blank:false, size:0..500)
        type(blank:false,size:0..200,unique:true)
    }
    static mapping = {
        version false
        table 'SimpleFile'
        id(name:'idFile',column:'idFile')
        nameOfFile(column:'nameOfFile')
        type(column:'type')        
    }
}
