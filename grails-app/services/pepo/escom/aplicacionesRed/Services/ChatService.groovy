package pepo.escom.aplicacionesRed.Services
import pepo.escom.aplicacionesRed.Other.PrettyChatContainer
import pepo.escom.aplicacionesRed.Other.PrettyFileLog
import grails.transaction.Transactional
import org.hibernate.transform.Transformers
@Transactional
class ChatService {
    def sessionFactory
    def grailsApplication
    def getPrettyChatLines() {
        //findAllByCreatedDateLessThanEquals(new Date(),[min:0,max:10,sort: 'createdDate', order: 'desc'])
        def session = sessionFactory.getCurrentSession()
        //def response = 
        /*
         *Date createdDate
        String userName
        String content
         **/
        def response = session.createQuery("select"+
                                 " chat.createdDate as createdDate,"+
                                 " user.username as userName,"+
                                 " chat.content as content"+
                                 " from ChatContent chat, User user "+
                                 " where chat.idUser = user.idUser and chat.createdDate <= :fechaActual order by chat.createdDate DESC")
        .setParameter("fechaActual",new Date())
        .setMaxResults(10)
        .setResultTransformer(Transformers.aliasToBean(PrettyChatContainer.class))
        .list();
        return response.reverse();
    }
    def getPrettyFileLog(){
        //def session = sessionFactory.getCurrentSession()
        //def response = 
        /*
         *Date createdDate
        String userName
        String content
         **/
        /*def response = session.createQuery("select"+
                                 " chat.createdDate as createdDate,"+
                                 " user.username as userName,"+
                                 " chat.content as content"+
                                 " from ChatContent chat, User user "+
                                 " where chat.idUser = user.idUser and chat.createdDate <= :fechaActual order by chat.createdDate DESC")
        .setParameter("fechaActual",new Date())
        .setMaxResults(10)
        .setResultTransformer(Transformers.aliasToBean(PrettyFileLog.class))
        .list();
        return response.reverse();*/
    }
}
