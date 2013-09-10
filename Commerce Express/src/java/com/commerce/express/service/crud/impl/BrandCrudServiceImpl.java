/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.Brand;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.BrandCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("BrandCrudService")
@Transactional
public class BrandCrudServiceImpl implements BrandCrudService {
    
    @Autowired
    private GenericDAO<Brand> dao;
    
    public final void setDao(final GenericDAO< Brand> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Brand.class);
    }
    
    public BrandCrudServiceImpl() {
    }

    @Override
    public Brand findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Brand> findAll() {
        setDao(dao);
        return dao.findAll();
    }
    
    @Override
    public void persist(Brand entity) {
        setDao(dao);
        dao.persist(entity);
    }
    
    @Override
    public void merge(Brand entity) {
        setDao(dao);
        dao.merge(entity);
    }
    
    @Override
    public void remove(Brand entity) {
        setDao(dao);
        dao.remove(entity);
    }
    
    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        Brand v = dao.findById(entityId);
        dao.remove(v);
    }
    
    @Override
    public List<Brand> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);
        
    }

    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }

    @Override
    public Brand getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }
    
    @Override
    public List<Brand> getEntitiesByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByPropertyName(name, value);
    }
    
    @Override
    public void persistMultipleEntities(List<Brand> object) {
        setDao(dao);
        dao.persistMultipleEntites(object);
    }
    
    @Override
    public void removeMultipleEntities(List<Brand> object) {
        setDao(dao);
        dao.removeMultipleEntities(object);
    }
}