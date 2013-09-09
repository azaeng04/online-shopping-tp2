/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.Users;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.UsersCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("usersCrudService")
@Transactional
public class UsersCrudServiceImpl implements UsersCrudService {

    @Autowired
    private GenericDAO<Users> dao;

    public final void setDao(final GenericDAO< Users> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Users.class);
    }
}
