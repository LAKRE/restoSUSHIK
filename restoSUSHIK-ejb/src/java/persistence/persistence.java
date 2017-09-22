
package persistence;

import caisse.Commande;
import caisse.LigneCommande;
import carte.Bidon;
import carte.Ingredient;
import carte.Produit;
import carte.ProduitFactice;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class persistence implements persistenceLocal {
   
    
    @PersistenceContext(unitName = "restoSUSHIK-ejbPU")
    private EntityManager em;

    @Override
    public void persist() {
        
       ProduitFactice p1=new ProduitFactice(20, "sushi");
       ProduitFactice p2=new ProduitFactice(20, "maki");
       ProduitFactice p3=new ProduitFactice(20, "sashimi");
       ProduitFactice p4=new ProduitFactice(5, "boule cocool");
       ProduitFactice p5=new ProduitFactice(10, "Tempura");
       LigneCommande l1= new LigneCommande(2, p1);
       LigneCommande l2= new LigneCommande(3, p2);
       LigneCommande l3= new LigneCommande(3, p3);
       LigneCommande l4= new LigneCommande(2, p4);
       LigneCommande l5= new LigneCommande(2, p5);
       Ingredient i1= new Ingredient("riz", 0);
       Ingredient i2= new Ingredient("saumon", 0);
       List<Ingredient> detailProduit= new ArrayList();
       detailProduit.add(i1);
       detailProduit.add(i2);
       p1.setIngredients(detailProduit);
       List<LigneCommande> detailCommande= new ArrayList<LigneCommande>();
       Commande premiere= new Commande(new Date(), 01);
       detailCommande.add(l1);
       detailCommande.add(l5);
       premiere.setLignes(detailCommande);
       l1.setCommentaire("menu11");
       l1.ajouterLigne(l2);
       l1.ajouterLigne(l3);
       l1.ajouterLigne(l4);
       l2.setCommentaire("entree");
       l3.setCommentaire("plat");
       l4.setCommentaire("dessert");
       l5.setCommentaire("a la carte");
       em.persist(p1);
       em.persist(p2);
       em.persist(p3);
       em.persist(p4);
       em.persist(p5);
       em.persist(l1);
       em.persist(l2);
       em.persist(l3);
       em.persist(l4);
       em.persist(l5);
       em.persist(i1);
       em.persist(i2);
       em.persist(premiere);
       System.out.println(l1);
       //System.out.println(premiere);
       em.flush(); 
       
       System.out.println("youpi ça marche");
        
    }

    
    
    
    
    
    
    
}
