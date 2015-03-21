package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.Administrator;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.AdministratorCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("AdministratorCrudService")
@Transactional
public class AdministratorCrudServiceImpl implements AdministratorCrudService {
    
    @Autowired
    private GenericDAO<Administrator> dao;
    
    public final void setDao(final GenericDAO< Administrator> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Administrator.class);
    }
    
    public AdministratorCrudServiceImpl() {
    }

    @Override
    public Administrator findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Administrator> findAll() {
        setDao(dao);
        return dao.findAll();
    }
    
    @Override
    public void persist(Administrator entity) {
        setDao(dao);
        dao.persist(entity);
    }
    
    @Override
    public void merge(Administrator entity) {
        setDao(dao);
        dao.merge(entity);
    }
    
    @Override
    public void remove(Administrator entity) {
        setDao(dao);
        dao.remove(entity);
    }
    
    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        Administrator v = dao.findById(entityId);
        dao.remove(v);
    }
    
    @Override
    public List<Administrator> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);
        
    }

    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }

    @Override
    public Administrator getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }
    
    @Override
    public List<Administrator> getEntitiesByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByPropertyName(name, value);
    }
    
    @Override
    public void persistMultipleEntities(List<Administrator> object) {
        setDao(dao);
        dao.persistMultipleEntites(object);
    }
    
    @Override
    public void removeMultipleEntities(List<Administrator> object) {
        setDao(dao);
        dao.removeMultipleEntities(object);
    }
}