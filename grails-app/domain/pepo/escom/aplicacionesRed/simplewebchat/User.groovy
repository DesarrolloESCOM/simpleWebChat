package pepo.escom.aplicacionesRed.simplewebchat

class User {
    Integer idUser
    String username
    String password
    String email
    static constraints = {
        idUser(nullable:true, blank:true)
        username(blank: false, size: 0..200, unique:true)
        password(blank:false, size:0..200)
        email(blank:false,size:0..200,unique:true)
    }
    static mapping = {
        version false
        table 'User'
        id(name:'idUser',column:'idUser')
        username(column:'username')
        password(column:'password')
        email(column:'email')
    }
}
