/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.OrderLine;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.OrderLineCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("OrderLineCrudService")
@Transactional
public class OrderLineCrudServiceImpl implements OrderLineCrudService {
    
    @Autowired
    private GenericDAO<OrderLine> dao;
    
    public final void setDao(final GenericDAO< OrderLine> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(OrderLine.class);
    }
    
    public OrderLineCrudServiceImpl() {
    }

    @Override
    public OrderLine findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<OrderLine> findAll() {
        setDao(dao);
        return dao.findAll();
    }
    
    @Override
    public void persist(OrderLine entity) {
        setDao(dao);
        dao.persist(entity);
    }
    
    @Override
    public void merge(OrderLine entity) {
        setDao(dao);
        dao.merge(entity);
    }
    
    @Override
    public void remove(OrderLine entity) {
        setDao(dao);
        dao.remove(entity);
    }
    
    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        OrderLine v = dao.findById(entityId);
        dao.remove(v);
    }
    
    @Override
    public List<OrderLine> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);
        
    }

    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }

    @Override
    public OrderLine getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }
    
    @Override
    public List<OrderLine> getEntitiesByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByPropertyName(name, value);
    }
    
    @Override
    public void persistMultipleEntities(List<OrderLine> object) {
        setDao(dao);
        dao.persistMultipleEntites(object);
    }
    
    @Override
    public void removeMultipleEntities(List<OrderLine> object) {
        setDao(dao);
        dao.removeMultipleEntities(object);
    }
}