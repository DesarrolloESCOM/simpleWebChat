package pepo.escom.aplicacionesRed.controllers

import pepo.escom.aplicacionesRed.simplewebchat.User
class LoginController {

    def index() {
        login()
    }
    def login(){
        User user = User.findByUsernameAndPassword(params?.user,params?.password)
        if(!usuario){
            render(action:"accede",params:params)
            return
        } else {
            session.user = user
            render(controller:"Chat", action:"mainChat")
        }
    }
    def logout(){
        session.user = null;
        render(view:"accede")
    }
    def signUp(){
        //render(view:"registro")
    }
    def signIn(){
        //render(view:"accede")
    }
}
