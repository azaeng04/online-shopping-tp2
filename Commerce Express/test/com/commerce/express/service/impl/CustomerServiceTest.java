/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.impl;

import com.commerce.express.app.facade.CommerceExpressServices;
import com.commerce.express.domain.Customer;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 *
 * @author om95446
 */
public class CustomerServiceTest {

    private static final CommerceExpressServices commerceExpressServices = CommerceExpressServices.getCommerceExpressServices();

    public CustomerServiceTest() {
    }

    /**
     * Test of getCustomerByUsername method, of class CustomerServiceImpl.
     */
    @Test
    public void testGetCustomerByUsername() {
        Customer customer = commerceExpressServices.getCustomerService().getCustomerByUsername("eEngelbrecht1");
        
        assertTrue(!customer.getId().toString().isEmpty());
    }
}
