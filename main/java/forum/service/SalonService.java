/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.dao.SalonDao;
import forum.entity.Salon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ETY
 */
@Service
public class SalonService {
    
    @Autowired
    private SalonDao dao;
    
    @Transactional
    public void save(Salon salon){
    dao.save(salon);
    }
    
    @Transactional
    public void update(Salon salon){
    dao.save(salon);
    }
    
    @Transactional
    public void delete(Salon salon){
    dao.delete(salon);
    }
    
    @Transactional
    public void deleteAll(){
    dao.deleteAll();
    }
    
    @Transactional
    public Salon find(Long salonid){
    return dao.findOne(salonid);
    }
    
    @Transactional
    public Iterable<Salon> findAll(){
    return dao.findAll();
    }
    
}
