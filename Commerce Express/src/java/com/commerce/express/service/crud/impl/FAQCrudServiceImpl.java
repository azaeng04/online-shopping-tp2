package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.FAQ;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.FAQCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("FAQCrudService")
@Transactional
public class FAQCrudServiceImpl implements FAQCrudService {
    
    @Autowired
    private GenericDAO<FAQ> dao;
    
    public final void setDao(final GenericDAO< FAQ> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(FAQ.class);
    }
    
    public FAQCrudServiceImpl() {
    }

    @Override
    public FAQ findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<FAQ> findAll() {
        setDao(dao);
        return dao.findAll();
    }
    
    @Override
    public void persist(FAQ entity) {
        setDao(dao);
        dao.persist(entity);
    }
    
    @Override
    public void merge(FAQ entity) {
        setDao(dao);
        dao.merge(entity);
    }
    
    @Override
    public void remove(FAQ entity) {
        setDao(dao);
        dao.remove(entity);
    }
    
    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        FAQ v = dao.findById(entityId);
        dao.remove(v);
    }
    
    @Override
    public List<FAQ> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);
        
    }

    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }

    @Override
    public FAQ getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }
    
    @Override
    public List<FAQ> getEntitiesByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByPropertyName(name, value);
    }
    
    @Override
    public void persistMultipleEntities(List<FAQ> object) {
        setDao(dao);
        dao.persistMultipleEntites(object);
    }
    
    @Override
    public void removeMultipleEntities(List<FAQ> object) {
        setDao(dao);
        dao.removeMultipleEntities(object);
    }
}