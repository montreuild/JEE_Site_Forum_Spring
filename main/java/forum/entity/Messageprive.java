/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author ETY
 */
@Entity
public class Messageprive implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String messageprive;
    
    @ManyToOne
    @JoinColumn(name = "expediteur_id")
    private Utilisateur expediteur;
    
    
    @ManyToOne
    @JoinColumn(name = "destinaire_id")
    private Utilisateur destinataire;
    
    
    //Constructeur

    public Messageprive(Long id, String messageprive, Utilisateur expediteur, Utilisateur destinataire) {
        this.id = id;
        this.messageprive = messageprive;
        this.expediteur = expediteur;
        this.destinataire = destinataire;
    }

    public Messageprive() {
    }

    public Messageprive(String messageprive, Utilisateur expediteur, Utilisateur destinataire) {
        this.messageprive = messageprive;
        this.expediteur = expediteur;
        this.destinataire = destinataire;
    }
    

    
    
    
    
    //Getter

    public String getMessageprive() {
        return messageprive;
    }

    public void setMessageprive(String messageprive) {
        this.messageprive = messageprive;
    }

    public Utilisateur getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(Utilisateur expediteur) {
        this.expediteur = expediteur;
    }

    public Utilisateur getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Utilisateur destinataire) {
        this.destinataire = destinataire;
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
        if (!(object instanceof Messageprive)) {
            return false;
        }
        Messageprive other = (Messageprive) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "forum.entity.Messageprive[ id=" + id + " ]";
    }
    
}
