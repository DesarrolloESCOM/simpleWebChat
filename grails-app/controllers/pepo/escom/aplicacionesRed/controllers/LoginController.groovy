package pepo.escom.aplicacionesRed.controllers

import pepo.escom.aplicacionesRed.simplewebchat.User
class LoginController {

    def index() {
        if(session.user){
            redirect(controller:"Chat", action:"index")
            return
        } else {
           signIn()
           return
        }
        
    }
    def login(){
        User user = User.findByUsernameAndPassword(params?.user,params?.password)
        if(!user){
            //render("No se encuentra el usuario")
            flash.message = "Error al acceder al sistema!"
            redirect(controler:"Login",action:"signIn")
            return
        } else {
            session.user = user            
            //render("OK!!!")
            redirect(controller:"Chat", action:"mainChat")
            return
        }
    }
    def logout(){
        session.user = null;
        render(view:"signIn")
    }
    def signUp(){
        if(session.user){
            redirect(controller:"Chat", action:"mainChat")
            return            
        } else {            
            render(view:"signUp")
            return
        }
        
    }
    def signIn(){
        if(session.user){
            redirect(controller:"Chat", action:"mainChat")
            return
        } else {
            render(view:"signIn")
            return
        }
        
    }
}
