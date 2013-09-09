/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.Administrator;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.AdministratorCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("administratorCrudService")
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
}
