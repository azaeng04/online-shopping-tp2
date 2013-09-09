/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.Address;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.AdministratorCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("addressCrudService")
@Transactional
public class AddressCrudServiceImpl implements AdministratorCrudService {

    @Autowired
    private GenericDAO<Address> dao;

    public final void setDao(final GenericDAO< Address> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Address.class);
    }

    public AddressCrudServiceImpl() {
    }
}
