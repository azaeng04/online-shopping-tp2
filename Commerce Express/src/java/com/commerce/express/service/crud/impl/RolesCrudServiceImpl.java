/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.Roles;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.RolesCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("rolesCrudService")
@Transactional
public class RolesCrudServiceImpl implements RolesCrudService {

    @Autowired
    private GenericDAO<Roles> dao;

    public final void setDao(final GenericDAO< Roles> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Roles.class);
    }
}
