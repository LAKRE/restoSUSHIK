package carte;

import caisse.LigneCommande;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Produit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    
    @Column(nullable = false)
    private String nom;
    @Column(nullable = true)
    private String image;
    @Column(nullable = false)
    private float prixHT;
    @Column(nullable = true)
    private String description;
    @Column(nullable = false)
    private int statut;

    @OneToMany
    @JoinColumn(name="PRODUIT_ID")
    private Collection<Ingredient> ingredients;
    
    private Collection<Menu> menus; 
    
//    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST},mappedBy = "produit")
//    private LigneCommande ligneCommande;
//    
//    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    private Evenement evenement;
   
    public Produit() {
        ingredients = new ArrayList<>();
        menus = new ArrayList<>();
    }
    
    public Produit(String nom, String image, float prixHT, String description, int statut) {
        this();
        this.nom = nom;
        this.image = image;
        this.prixHT = prixHT;
        this.description = description;
        this.statut = statut;
    }

//    public Evenement getEvenement() {
//        return evenement;
//    }
//
//    public void setEvenement(Evenement evenement) {
//        this.evenement = evenement;
//    }

    
    
    public Collection<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Collection<Menu> menus) {
        this.menus = menus;
    }
    

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

//    public LigneCommande getLigneCommande() {
//        return ligneCommande;
//    }
//
//    public void setLigneCommande(LigneCommande ligneCommande) {
//        this.ligneCommande = ligneCommande;
//    }
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(float prixHT) {
        this.prixHT = prixHT;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }
    
    
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carte.Produit[ id=" + id + ", nom="+nom+" ]";
    }
    
}
