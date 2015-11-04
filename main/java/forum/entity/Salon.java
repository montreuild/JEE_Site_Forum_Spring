/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author ETY
 */
@Entity
public class Salon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    private String titreSalon;
    
    @JoinColumn(name = "user_id")
    @ManyToOne
    private Utilisateur user;
    
    @OneToMany(mappedBy = "salon")
    private List<Sujet> listSujets=new ArrayList<Sujet>();
    
    @ManyToMany(mappedBy = "listSalonAbonnes")
    private List<Utilisateur> listeUsersAbonnes;

    
        
    //Constructeur
    
    
    
    public Salon(Long id, String titreSalon, Utilisateur user) {    
        this.id = id;
        this.titreSalon = titreSalon;
        this.user = user;
    }

    public Salon() {
    }

    //Setter Getter

    public String getTitreSalon() {
        return titreSalon;
    }

    public void setTitreSalon(String titreSalon) {
        this.titreSalon = titreSalon;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public List<Sujet> getListSujets() {
        return listSujets;
    }

    public void setListSujets(List<Sujet> listSujets) {
        this.listSujets = listSujets;
    }

   

    public List<Utilisateur> getListeUsersAbonnes() {
        return listeUsersAbonnes;
    }

    public void setListeUsersAbonnes(List<Utilisateur> listeUsersAbonnes) {
        this.listeUsersAbonnes = listeUsersAbonnes;
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
        if (!(object instanceof Salon)) {
            return false;
        }
        Salon other = (Salon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "forum.entity.Salon[ id=" + id + " ]";
    }
    
}
