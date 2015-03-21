package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.Category;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.CategoryCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("CategoryCrudService")
@Transactional
public class CategoryCrudServiceImpl implements CategoryCrudService {
    
    @Autowired
    private GenericDAO<Category> dao;
    
    public final void setDao(final GenericDAO< Category> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Category.class);
    }
    
    public CategoryCrudServiceImpl() {
    }

    @Override
    public Category findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Category> findAll() {
        setDao(dao);
        return dao.findAll();
    }
    
    @Override
    public void persist(Category entity) {
        setDao(dao);
        dao.persist(entity);
    }
    
    @Override
    public void merge(Category entity) {
        setDao(dao);
        dao.merge(entity);
    }
    
    @Override
    public void remove(Category entity) {
        setDao(dao);
        dao.remove(entity);
    }
    
    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        Category v = dao.findById(entityId);
        dao.remove(v);
    }
    
    @Override
    public List<Category> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);
        
    }

    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }

    @Override
    public Category getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }
    
    @Override
    public List<Category> getEntitiesByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByPropertyName(name, value);
    }
    
    @Override
    public void persistMultipleEntities(List<Category> object) {
        setDao(dao);
        dao.persistMultipleEntites(object);
    }
    
    @Override
    public void removeMultipleEntities(List<Category> object) {
        setDao(dao);
        dao.removeMultipleEntities(object);
    }
}