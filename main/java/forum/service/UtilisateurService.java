/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.dao.UtilisateurDao;
import forum.entity.Utilisateur;
import forum.exception.LoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ETY
 */
@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurDao dao;

    @Transactional
    public void save(Utilisateur user) {
        dao.save(user);
    }

    @Transactional
    public void update(Utilisateur user) {
        dao.save(user);
    }

    @Transactional
    public void delete(Utilisateur user) {
        dao.delete(user);
    }

    @Transactional
    public void deleteAll() {
        dao.deleteAll();
    }

    @Transactional
    public Utilisateur find(Long userid) {
        return dao.findOne(userid);
    }

    @Transactional
    public Iterable<Utilisateur> findAll() {
        return dao.findAll();
    }

    @Transactional
    public void inscription(String login, String mdp) {
        Utilisateur user = new Utilisateur(login, mdp, Utilisateur.type.USER, Utilisateur.statu.INACTIF);
        dao.save(user);
    }

    @Transactional
    public void validerInscription(long utilisateurid) {

        Utilisateur user = dao.findOne(utilisateurid);
        user.setStatuUtilisateur(Utilisateur.statu.ACTIF);
        dao.save(user);
    }

    @Transactional
    public void login(String login, String mdp)throws LoginException{

        Utilisateur user = new Utilisateur();

        user = dao.findOneByLoginAndMdp(login, mdp);
        
        if (user==null)
        {
            throw new LoginException();
        }
        else if(user.getStatuUtilisateur()==Utilisateur.statu.ACTIF)
        {
            System.out.println("Connexion succes de"+user.getLogin());
        }
        else{
            System.out.println("Renvoyer un mail d'activation");
        }
            
    }
}
