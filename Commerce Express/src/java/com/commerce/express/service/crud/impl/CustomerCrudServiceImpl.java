/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.Customer;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.CustomerCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("customerCrudService")
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
}
