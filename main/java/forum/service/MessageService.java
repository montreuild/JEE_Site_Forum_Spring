/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.dao.MessageDao;
import forum.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ETY
 */
@Service
public class MessageService {
    
    @Autowired
    private MessageDao dao;
    
    @Transactional
    public void save(Message message){
    dao.save(message);
    }
    
    @Transactional
    public void update(Message message){
    dao.save(message);
    }
    
    @Transactional
    public void delete(Message message){
    dao.delete(message);
    }
    
    @Transactional
    public void deleteAll(){
    dao.deleteAll();
    }
    
    @Transactional
    public Message find(Long messageid){
    return dao.findOne(messageid);
    }
    
    @Transactional
    public Iterable<Message> findAll(){
    return dao.findAll();
    }
    
}
