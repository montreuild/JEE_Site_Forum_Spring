/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.dao.MessagepriveDao;
import forum.entity.Messageprive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ETY
 */
@Service
public class MessagepriveService {

    @Autowired
    private MessagepriveDao dao;

    @Autowired
    private UtilisateurService daoUser;

    @Transactional
    public void save(Messageprive messageprive) {
        dao.save(messageprive);
        messageprive.getDestinataire().getMessagesPriveRecus().add(messageprive);
        messageprive.getExpediteur().getMessagesPriveEnvoyes().add(messageprive);
        daoUser.save(messageprive.getDestinataire());
        daoUser.save(messageprive.getExpediteur());
    }

    @Transactional
    public void update(Messageprive messageprive) {
        dao.save(messageprive);
    }

    @Transactional
    public void delete(Messageprive messageprive) {
        dao.delete(messageprive);
    }

    @Transactional
    public void deleteAll() {
        dao.deleteAll();
    }

    @Transactional
    public Messageprive find(Long messagepriveid) {
        return dao.findOne(messagepriveid);
    }

    @Transactional
    public Iterable<Messageprive> findAll() {
        return dao.findAll();
    }

}
