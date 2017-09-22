/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caisse;

import carte.Produit;
import carte.ProduitFactice;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author cdi417
 */
@Entity
public class LigneCommande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int quantite;
    
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private ProduitFactice produit;
    
    private String commentaire;
    
    private Commande commande;
    
    private LigneCommande origine;
    
    private int statut;
    
    private String typeCuisson;
    
    @OneToMany
    @JoinColumn(name = "ORIGINE_ID")
    private List<LigneCommande> lignes=new ArrayList<>();

    public LigneCommande() {
        //lignes=new ArrayList<>();
    }

    public LigneCommande(int quantite, ProduitFactice Produit) {
        //lignes=new ArrayList<>();
        this.quantite = quantite;
        this.produit = Produit;
        
    }

    public LigneCommande(LigneCommande origine) {
        this.origine = origine;
    }

    public LigneCommande(List<LigneCommande> lignes) {
        this.lignes = lignes;
    }

    

    public ProduitFactice getProduit() {
        return produit;
    }

    public void setProduit(ProduitFactice Produit) {
        this.produit = Produit;
    }

    public LigneCommande getOrigine() {
        return origine;
    }

    public void setOrigine(LigneCommande origine) {
        this.origine = origine;
    }

    public List<LigneCommande> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneCommande> lignes) {
        this.lignes = lignes;
    }
    
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public String getTypeCuisson() {
        return typeCuisson;
    }

    public void setTypeCuisson(String typeCuisson) {
        this.typeCuisson = typeCuisson;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public float getPrixTotalTTC(){
        int total=0;
        
        if(!lignes.isEmpty()){
  
        }

        return 0;
    }
    
    public void ajouterLigne(LigneCommande l1){
        lignes.add(l1);
        
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
        if (!(object instanceof LigneCommande)) {
            return false;
        }
        LigneCommande other = (LigneCommande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        String s= "Ligne de commande N°"+id+", "+"produit:"+produit+"\n"+
                "lignes internes "+lignes;
        
        return s;
    }
    
}
