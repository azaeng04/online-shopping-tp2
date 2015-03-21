package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.WishList;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.WishListCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("WishListCrudService")
@Transactional
public class WishListCrudServiceImpl implements WishListCrudService {
    
    @Autowired
    private GenericDAO<WishList> dao;
    
    public final void setDao(final GenericDAO< WishList> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(WishList.class);
    }
    
    public WishListCrudServiceImpl() {
    }

    @Override
    public WishList findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<WishList> findAll() {
        setDao(dao);
        return dao.findAll();
    }
    
    @Override
    public void persist(WishList entity) {
        setDao(dao);
        dao.persist(entity);
    }
    
    @Override
    public void merge(WishList entity) {
        setDao(dao);
        dao.merge(entity);
    }
    
    @Override
    public void remove(WishList entity) {
        setDao(dao);
        dao.remove(entity);
    }
    
    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        WishList v = dao.findById(entityId);
        dao.remove(v);
    }
    
    @Override
    public List<WishList> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);
        
    }

    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }

    @Override
    public WishList getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }
    
    @Override
    public List<WishList> getEntitiesByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByPropertyName(name, value);
    }
    
    @Override
    public void persistMultipleEntities(List<WishList> object) {
        setDao(dao);
        dao.persistMultipleEntites(object);
    }
    
    @Override
    public void removeMultipleEntities(List<WishList> object) {
        setDao(dao);
        dao.removeMultipleEntities(object);
    }
}