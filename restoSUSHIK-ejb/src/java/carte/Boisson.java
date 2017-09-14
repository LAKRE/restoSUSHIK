
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Boisson implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    
    @Column(nullable = false)
    private String nom;
    
    private float tauxAlcool;
    
    @Column(nullable = false)
    private float volume;
    @Column(nullable = false)
    private float prixHT;
    @Column(nullable = false)
    private int statut;

    @ManyToMany(mappedBy = "boisson") 
    private Collection<Ingredient> ingredients;
    
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private LigneCommande ligneCommande;
    
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Evenement evenement;
            
    public Boisson() {
        ingredients = new ArrayList<>();
    }
    
    public Boisson(String nom, float tauxAlcool, float volume, float prixHT, int statut) {
        this();
        this.nom = nom;
        this.tauxAlcool = tauxAlcool;
        this.volume = volume;
        this.prixHT = prixHT;
        this.statut = statut;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }
    

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public LigneCommande getLigneCommande() {
        return ligneCommande;
    }

    public void setLigneCommande(LigneCommande ligneCommande) {
        this.ligneCommande = ligneCommande;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getTauxAlcool() {
        return tauxAlcool;
    }

    public void setTauxAlcool(float tauxAlcool) {
        this.tauxAlcool = tauxAlcool;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public float getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(float prixHT) {
        this.prixHT = prixHT;
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
        if (!(object instanceof Boisson)) {
            return false;
        }
        Boisson other = (Boisson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carte.Boisson[ id=" + id + " ]";
    }
    
}
