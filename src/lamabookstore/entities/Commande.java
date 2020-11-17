/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamabookstore.entities;

import java.util.Date;


public class Commande  {

    private static final long serialVersionUID = 1L;
   
    private Integer id;
   
    
    private Date dateCommande;
    
    private int qte;
    
    private int idProduit;
    
    private int idClient;
    
    private int prixUnit;

    public Commande() {
    }

    public Commande(Integer id) {
        this.id = id;
    }

    public Commande(Integer id, Date dateCommande, int qte, int idProduit, int idClient, int prixUnit) {
        this.id = id;
        this.dateCommande = dateCommande;
        this.qte = qte;
        this.idProduit = idProduit;
        this.idClient = idClient;
        this.prixUnit = prixUnit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getPrixUnit() {
        return prixUnit;
    }

    public void setPrixUnit(int prixUnit) {
        this.prixUnit = prixUnit;
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
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lamabookstore.entities.Commande[ id=" + id + " ]";
    }
    
}
