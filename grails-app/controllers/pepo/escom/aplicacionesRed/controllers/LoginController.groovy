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
            println("No hay sesion, se procede al registro")
            if(!(params?.password || params?.username)){
                //render("Se redirecciona al registro")
                render(view:"signUp", model:[:])
            } else {
                println("Hay parametros, se intenta el registro o si no ser redirecciona con los mensajes de error")
                try{
                    User userToBeSaved = new User(params)
                    if(userToBeSaved.save(flush:true,failOnError:true)){
                        session.user = userToBeSaved
                        redirect(Controller:"Chat",action:"mainChat")
                        //render("Se guardó el usuario!")
                        return
                    } else {
                        //render("Error al guardar el usuario")
                        render(view:"signUp",model:[user:userToBeSaved])
                        return
                    }
                }catch(Exception e){
                    e.printStackTrace();
                    render("${e.getLocalizedMessage()}")
                    return
                }
            }                     
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
