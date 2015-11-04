/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.test;

import forum.entity.Messageprive;
import forum.entity.Utilisateur;
import forum.service.MessagepriveService;
import forum.service.UtilisateurService;
import forum.spring.SpringConfig;
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
public class MessagepriveServiceJUnitTest {

    @Autowired
    public MessagepriveService servicemsg;
    @Autowired
    public UtilisateurService serviceuser;

    @Before
    public void setUp() {

        //Supprimer tous les utilisateurs et les message privé
        servicemsg.deleteAll();
        serviceuser.deleteAll();

        //Ajout de 2 utilisateurs
        Utilisateur user1 = new Utilisateur(1L, "dd", "dd", Utilisateur.type.ADMIN, Utilisateur.statu.ACTIF);
        Utilisateur user2 = new Utilisateur(2L, "bb", "bb", Utilisateur.type.USER, Utilisateur.statu.INACTIF);
        serviceuser.save(user1);
        serviceuser.save(user2);

        //Ajouter 1 messagesprives
        Messageprive msg1 = new Messageprive(1L, "Coucou dd c'est bb", user2, user1);
        servicemsg.save(msg1);


        System.out.println("Affichage de user 1 reçu.");

        Utilisateur usertest = serviceuser.find(1L);
        System.out.println(serviceuser.find(1L).getMessagesPriveRecus().get(0));
       // System.out.println(usertest.getMessagesPriveEnvoyes().get(0));
        System.out.println("Affichage de user 2 reçu.");
      //  System.out.println(serviceuser.find(2L).getMessagesPriveRecus().get(0));
        System.out.println(serviceuser.find(2L).getMessagesPriveEnvoyes().get(0));

    }

    @Test
    public void Message1iOk() {
        Assert.assertEquals(1,serviceuser.find(1L).getMessagesPriveRecus().size());
    }

}
