/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.test;

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
public class UtilisateurServiceJUnitTest {

    @Autowired
    public UtilisateurService service;
    @Autowired
    public MessagepriveService servicemsg;

    @Before
    public void setUp() {

        //Supprimer tous les utilisateurs
        servicemsg.deleteAll();
        service.deleteAll();

        //Ajouter 2 utilisateurs
        service.save(new Utilisateur(3L, "dd", "dd", Utilisateur.type.ADMIN, Utilisateur.statu.ACTIF));
        service.save(new Utilisateur(4L, "bb", "bb", Utilisateur.type.USER, Utilisateur.statu.INACTIF));
    }

    @Test
    public void utilisateur3isbbOk() {
        Assert.assertEquals("bb", service.find(4L).getLogin());
    }

}
