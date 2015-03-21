package com.commerce.express.service.crud.impl;


import com.commerce.express.domain.AccessDetails;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.AccessDetailsCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("AccessDetailsCrudService")
@Transactional
public class AccessDetailsCrudServiceImpl implements AccessDetailsCrudService {
    
    @Autowired
    private GenericDAO<AccessDetails> dao;
    
    public final void setDao(final GenericDAO< AccessDetails> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(AccessDetails.class);
    }
    
    public AccessDetailsCrudServiceImpl() {
    }

    @Override
    public AccessDetails findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<AccessDetails> findAll() {
        setDao(dao);
        return dao.findAll();
    }
    
    @Override
    public void persist(AccessDetails entity) {
        setDao(dao);
        dao.persist(entity);
    }
    
    @Override
    public void merge(AccessDetails entity) {
        setDao(dao);
        dao.merge(entity);
    }
    
    @Override
    public void remove(AccessDetails entity) {
        setDao(dao);
        dao.remove(entity);
    }
    
    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        AccessDetails v = dao.findById(entityId);
        dao.remove(v);
    }
    
    @Override
    public List<AccessDetails> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);
        
    }

    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }

    @Override
    public AccessDetails getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }
    
    @Override
    public List<AccessDetails> getEntitiesByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByPropertyName(name, value);
    }
    
    @Override
    public void persistMultipleEntities(List<AccessDetails> object) {
        setDao(dao);
        dao.persistMultipleEntites(object);
    }
    
    @Override
    public void removeMultipleEntities(List<AccessDetails> object) {
        setDao(dao);
        dao.removeMultipleEntities(object);
    }
}