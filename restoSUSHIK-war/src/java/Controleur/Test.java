package Controleur;

import carte.Produit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistence.persistenceLocal;

public class Test {
    persistenceLocal persistence = lookuppersistenceLocal();
  
    public Test(){
    }
    
    public void persister(){

        persistence.persist();
        
    }
    

    private persistenceLocal lookuppersistenceLocal() {
        try {
            Context c = new InitialContext();
            return (persistenceLocal) c.lookup("java:global/restoSUSHIK/restoSUSHIK-ejb/persistence!persistence.persistenceLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
