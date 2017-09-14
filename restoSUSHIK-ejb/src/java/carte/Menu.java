package carte;

import caisse.Commande;
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
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private float prixHT;
    
    @ManyToMany(mappedBy = "menu")
    private Collection<Boisson> boissons;
    @ManyToMany(mappedBy = "menu")
    private Collection<Produit> produits;
    
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private LigneCommande ligneCommmande;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Evenement evenement;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Tva tva;

    public Menu() {
        boissons = new ArrayList<>();
        produits = new ArrayList<>();
    }

    public Menu(String nom, float prixHT) {
        this();
        this.nom = nom;
        this.prixHT = prixHT;
    }

    public Collection<Boisson> getBoissons() {
        return boissons;
    }

    public void setBoissons(Collection<Boisson> boissons) {
        this.boissons = boissons;
    }

    public Collection<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }

    public LigneCommande getLigneCommmande() {
        return ligneCommmande;
    }

    public void setLigneCommmande(LigneCommande ligneCommmande) {
        this.ligneCommmande = ligneCommmande;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public Tva getTva() {
        return tva;
    }

    public void setTva(Tva tva) {
        this.tva = tva;
    }

    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(float prixHT) {
        this.prixHT = prixHT;
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
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carte.Menu[ id=" + id + " ]";
    }
    
}
