/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.Product;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.ProductCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("ProductCrudService")
@Transactional
public class ProductCrudServiceImpl implements ProductCrudService {
    
    @Autowired
    private GenericDAO<Product> dao;
    
    public final void setDao(final GenericDAO< Product> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Product.class);
    }
    
    public ProductCrudServiceImpl() {
    }

    @Override
    public Product findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Product> findAll() {
        setDao(dao);
        return dao.findAll();
    }
    
    @Override
    public void persist(Product entity) {
        setDao(dao);
        dao.persist(entity);
    }
    
    @Override
    public void merge(Product entity) {
        setDao(dao);
        dao.merge(entity);
    }
    
    @Override
    public void remove(Product entity) {
        setDao(dao);
        dao.remove(entity);
    }
    
    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        Product v = dao.findById(entityId);
        dao.remove(v);
    }
    
    @Override
    public List<Product> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);
        
    }

    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }

    @Override
    public Product getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }
    
    @Override
    public List<Product> getEntitiesByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByPropertyName(name, value);
    }
    
    @Override
    public void persistMultipleEntities(List<Product> object) {
        setDao(dao);
        dao.persistMultipleEntites(object);
    }
    
    @Override
    public void removeMultipleEntities(List<Product> object) {
        setDao(dao);
        dao.removeMultipleEntities(object);
    }
}