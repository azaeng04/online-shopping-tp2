/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.impl;

import com.commerce.express.service.CustomerService;
import com.commerce.express.service.crud.CustomerCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Owner
 */
@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerCrudService customerCrudService;
    private static CustomerServiceImpl customerServiceImpl;
    
    private CustomerServiceImpl() {
    }
    
    public synchronized static CustomerServiceImpl getInstance() {
        if (customerServiceImpl == null) {
            customerServiceImpl = new CustomerServiceImpl();
        }
        return customerServiceImpl;
    }
}