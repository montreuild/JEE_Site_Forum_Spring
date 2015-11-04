/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.dao.SujetDao;
import forum.entity.Sujet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ETY
 */
@Service
public class SujetService {
    
    @Autowired
    private SujetDao dao;
    
    @Transactional
    public void save(Sujet sujet){
    dao.save(sujet);
    }
    
    @Transactional
    public void update(Sujet sujet){
    dao.save(sujet);
    }
    
    @Transactional
    public void delete(Sujet sujet){
    dao.delete(sujet);
    }
    
    @Transactional
    public void deleteAll(){
    dao.deleteAll();
    }
    
    @Transactional
    public Sujet find(Long sujetid){
    return dao.findOne(sujetid);
    }
    
    @Transactional
    public Iterable<Sujet> findAll(){
    return dao.findAll();
    }
    
}
