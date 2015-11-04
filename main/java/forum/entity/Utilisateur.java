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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author ETY
 */
@Entity
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum type {

        ADMIN, MOD, USER
    };
    
    public enum statu {

        ACTIF, INACTIF
    };

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;
    private String mdp;
    @Enumerated(EnumType.STRING)
    private type type_user;
    
    @Enumerated(EnumType.STRING)
    private statu statuUtilisateur;
     

    @OneToMany(mappedBy = "destinataire")
    private List<Messageprive> messagesPriveRecus= new ArrayList<Messageprive>();

    @OneToMany(mappedBy = "expediteur")
    private List<Messageprive> messagesPriveEnvoyes= new ArrayList<Messageprive>();

    @OneToMany(mappedBy = "user")
    private List<Salon> listSalons = new ArrayList<Salon>();

    @OneToMany(mappedBy = "user")
    private List<Sujet> listSujets = new ArrayList<Sujet>();

    @OneToMany(mappedBy = "user")
    private List<Message> listMessages = new ArrayList<Message>();

    @JoinTable(name = "user_salon")
    @ManyToMany
    private List<Salon> listSalonAbonnes = new ArrayList<Salon>();

    //Constructeur
    public Utilisateur() {
    }

    public Utilisateur(Long id, String login, String mdp, type type_user, statu statuUtilisateur) {
        this.id = id;
        this.login = login;
        this.mdp = mdp;
        this.type_user = type_user;
        this.statuUtilisateur = statuUtilisateur;
    }
    public Utilisateur( String login, String mdp, type type_user, statu statuUtilisateur) {
        this.login = login;
        this.mdp = mdp;
        this.type_user = type_user;
        this.statuUtilisateur = statuUtilisateur;
    }

    //Setter Getter
    public void setMessagesPriveEnvoyes(List<Messageprive> messagesPriveEnvoyes) {
        this.messagesPriveEnvoyes = messagesPriveEnvoyes;
    }

    public void setMessagesPriveRecus(List<Messageprive> messagesPriveRecus) {
        this.messagesPriveRecus = messagesPriveRecus;
    }

    public statu getStatuUtilisateur() {
        return statuUtilisateur;
    }

    public void setStatuUtilisateur(statu statuUtilisateur) {
        this.statuUtilisateur = statuUtilisateur;
    }

    public List<Messageprive> getMessagesPriveRecus() {
        return messagesPriveRecus;
    }

    public List<Messageprive> getMessagesPriveEnvoyes() {
        return messagesPriveEnvoyes;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public type getType_user() {
        return type_user;
    }

    public void setType_user(type type_user) {
        this.type_user = type_user;
    }

    public List<Salon> getListSalons() {
        return listSalons;
    }

    public void setListSalons(List<Salon> listSalons) {
        this.listSalons = listSalons;
    }

    public List<Sujet> getListSujets() {
        return listSujets;
    }

    public void setListSujets(List<Sujet> listSujets) {
        this.listSujets = listSujets;
    }

    public List<Message> getListMessages() {
        return listMessages;
    }

    public void setListMessages(List<Message> listMessages) {
        this.listMessages = listMessages;
    }

    public List<Salon> getListSalonAbonnes() {
        return listSalonAbonnes;
    }

    public void setListSalonAbonnes(List<Salon> listSalonAbonnes) {
        this.listSalonAbonnes = listSalonAbonnes;
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
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "forum.entity.Utilisateur[ id=" + id + " ]";
    }

}
