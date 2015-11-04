/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.test;

import forum.entity.Messageprive;
import forum.entity.Utilisateur;
import forum.exception.LoginException;
import forum.service.MessagepriveService;
import forum.service.UtilisateurService;
import forum.spring.SpringConfig;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author ETY
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfig.class)
public class UtilisateurServiceConnexionJUnitTest {

    @Autowired
    public UtilisateurService serviceuser;
    @Autowired
    public MessagepriveService servicemsg;

    @Before
    public void setUp() {

        //Supprimer tous les utilisateurs et les message privé
        servicemsg.deleteAll();
        serviceuser.deleteAll();

        //Ajout de 2 utilisateurs
        Utilisateur user1 = new Utilisateur("dd", "dd", Utilisateur.type.ADMIN, Utilisateur.statu.ACTIF);
        Utilisateur user2 = new Utilisateur("bb", "bb", Utilisateur.type.USER, Utilisateur.statu.INACTIF);
        serviceuser.save(user1);
        serviceuser.save(user2);

    }

    @Test
    public void Message1iOk() {

        try {
            serviceuser.login("bb", "bb");
        } catch (LoginException ex) {
            Logger.getLogger(UtilisateurServiceConnexionJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
