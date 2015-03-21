package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.Customer;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.CustomerCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("CustomerCrudService")
@Transactional
public class CustomerCrudServiceImpl implements CustomerCrudService {
    
    @Autowired
    private GenericDAO<Customer> dao;
    
    public final void setDao(final GenericDAO< Customer> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Customer.class);
    }
    
    public CustomerCrudServiceImpl() {
    }

    @Override
    public Customer findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        setDao(dao);
        return dao.findAll();
    }
    
    @Override
    public void persist(Customer entity) {
        setDao(dao);
        dao.persist(entity);
    }
    
    @Override
    public void merge(Customer entity) {
        setDao(dao);
        dao.merge(entity);
    }
    
    @Override
    public void remove(Customer entity) {
        setDao(dao);
        dao.remove(entity);
    }
    
    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        Customer v = dao.findById(entityId);
        dao.remove(v);
    }
    
    @Override
    public List<Customer> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);
        
    }

    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }

    @Override
    public Customer getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }
    
    @Override
    public List<Customer> getEntitiesByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByPropertyName(name, value);
    }
    
    @Override
    public void persistMultipleEntities(List<Customer> object) {
        setDao(dao);
        dao.persistMultipleEntites(object);
    }
    
    @Override
    public void removeMultipleEntities(List<Customer> object) {
        setDao(dao);
        dao.removeMultipleEntities(object);
    }
}