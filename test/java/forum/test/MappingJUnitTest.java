/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.test;

import forum.dao.UtilisateurDao;
import forum.entity.Utilisateur;
import forum.spring.SpringConfig;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ETY
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfig.class)
public class MappingJUnitTest {
    
     @Autowired
    public UtilisateurDao dao;
     
    @Before
    @Transactional
    public void setUp() {

        //Supprimer tous les utilisateurs
        dao.deleteAll();

        //Ajouter 2 utilisateurs
        dao.save(new Utilisateur(1L, "dd", "dd", Utilisateur.type.ADMIN, Utilisateur.statu.ACTIF));
        dao.save(new Utilisateur(2L, "bb", "bb", Utilisateur.type.USER, Utilisateur.statu.INACTIF));
    }

    @Test
    public void UtilisateurisddOk() {
        Assert.assertEquals("dd", dao.findOne(1L).getLogin());
    }
 
}
