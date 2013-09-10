/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.impl;

import com.commerce.express.service.AdministratorService;
import com.commerce.express.service.crud.AccessDetailsCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Owner
 */
@Service("AdministratorService")
public class AccessDetailsServiceImpl implements AdministratorService {

    @Autowired
    private AccessDetailsCrudService administratorCrudService;
    private static AccessDetailsServiceImpl accessDetailsServiceImpl;
    
    private AccessDetailsServiceImpl() {
    }
    
    public synchronized static AccessDetailsServiceImpl getInstance() {
        if (accessDetailsServiceImpl == null) {
            accessDetailsServiceImpl = new AccessDetailsServiceImpl();
        }
        return accessDetailsServiceImpl;
    }
}