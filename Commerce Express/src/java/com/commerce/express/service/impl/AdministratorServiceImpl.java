/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.impl;

import com.commerce.express.service.AdministratorService;
import com.commerce.express.service.crud.AdministratorCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Owner
 */
@Service("AdministratorService")
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorCrudService administratorCrudService;
    private static AdministratorServiceImpl administratorServiceImpl;
    
    private AdministratorServiceImpl() {
    }
    
    public synchronized static AdministratorServiceImpl getInstance() {
        if (administratorServiceImpl == null) {
            administratorServiceImpl = new AdministratorServiceImpl();
        }
        return administratorServiceImpl;
    }
}