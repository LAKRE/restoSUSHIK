
package persistence;

import carte.Bidon;
import carte.Produit;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class persistence implements persistenceLocal {
   
    
    @PersistenceContext(unitName = "restoSUSHIK-ejbPU")
    private EntityManager em;

    @Override
    public void persist() {
        
        Bidon p1=new Bidon("etetere");
        
       
       em.persist(p1);
       em.flush(); 
       
       System.out.println("youpi ça marche");
        
    }

    
    
    
    
    
    
    
}
