/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.Rating;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.RatingCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("RatingCrudService")
@Transactional
public class RatingCrudServiceImpl implements RatingCrudService {
    
    @Autowired
    private GenericDAO<Rating> dao;
    
    public final void setDao(final GenericDAO< Rating> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Rating.class);
    }
    
    public RatingCrudServiceImpl() {
    }

    @Override
    public Rating findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Rating> findAll() {
        setDao(dao);
        return dao.findAll();
    }
    
    @Override
    public void persist(Rating entity) {
        setDao(dao);
        dao.persist(entity);
    }
    
    @Override
    public void merge(Rating entity) {
        setDao(dao);
        dao.merge(entity);
    }
    
    @Override
    public void remove(Rating entity) {
        setDao(dao);
        dao.remove(entity);
    }
    
    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        Rating v = dao.findById(entityId);
        dao.remove(v);
    }
    
    @Override
    public List<Rating> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);
        
    }

    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }

    @Override
    public Rating getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }
    
    @Override
    public List<Rating> getEntitiesByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByPropertyName(name, value);
    }
    
    @Override
    public void persistMultipleEntities(List<Rating> object) {
        setDao(dao);
        dao.persistMultipleEntites(object);
    }
    
    @Override
    public void removeMultipleEntities(List<Rating> object) {
        setDao(dao);
        dao.removeMultipleEntities(object);
    }
}