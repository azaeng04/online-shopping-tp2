/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.ProductStatus;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.ProductStatusCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("ProductStatusCrudService")
@Transactional
public class ProductStatusCrudServiceImpl implements ProductStatusCrudService {
    
    @Autowired
    private GenericDAO<ProductStatus> dao;
    
    public final void setDao(final GenericDAO< ProductStatus> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(ProductStatus.class);
    }
    
    public ProductStatusCrudServiceImpl() {
    }

    @Override
    public ProductStatus findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<ProductStatus> findAll() {
        setDao(dao);
        return dao.findAll();
    }
    
    @Override
    public void persist(ProductStatus entity) {
        setDao(dao);
        dao.persist(entity);
    }
    
    @Override
    public void merge(ProductStatus entity) {
        setDao(dao);
        dao.merge(entity);
    }
    
    @Override
    public void remove(ProductStatus entity) {
        setDao(dao);
        dao.remove(entity);
    }
    
    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        ProductStatus v = dao.findById(entityId);
        dao.remove(v);
    }
    
    @Override
    public List<ProductStatus> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);
        
    }

    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }

    @Override
    public ProductStatus getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }
    
    @Override
    public List<ProductStatus> getEntitiesByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByPropertyName(name, value);
    }
    
    @Override
    public void persistMultipleEntities(List<ProductStatus> object) {
        setDao(dao);
        dao.persistMultipleEntites(object);
    }
    
    @Override
    public void removeMultipleEntities(List<ProductStatus> object) {
        setDao(dao);
        dao.removeMultipleEntities(object);
    }
}