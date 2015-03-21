package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.Users;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.UsersCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("UsersCrudService")
@Transactional
public class UsersCrudServiceImpl implements UsersCrudService {
    
    @Autowired
    private GenericDAO<Users> dao;
    
    public final void setDao(final GenericDAO< Users> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Users.class);
    }
    
    public UsersCrudServiceImpl() {
    }

    @Override
    public Users findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Users> findAll() {
        setDao(dao);
        return dao.findAll();
    }
    
    @Override
    public void persist(Users entity) {
        setDao(dao);
        dao.persist(entity);
    }
    
    @Override
    public void merge(Users entity) {
        setDao(dao);
        dao.merge(entity);
    }
    
    @Override
    public void remove(Users entity) {
        setDao(dao);
        dao.remove(entity);
    }
    
    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        Users v = dao.findById(entityId);
        dao.remove(v);
    }
    
    @Override
    public List<Users> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);
        
    }

    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }

    @Override
    public Users getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }
    
    @Override
    public List<Users> getEntitiesByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByPropertyName(name, value);
    }
    
    @Override
    public void persistMultipleEntities(List<Users> object) {
        setDao(dao);
        dao.persistMultipleEntites(object);
    }
    
    @Override
    public void removeMultipleEntities(List<Users> object) {
        setDao(dao);
        dao.removeMultipleEntities(object);
    }
}