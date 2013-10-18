/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.impl;

import com.commerce.express.app.facade.CommerceExpressServices;
import com.commerce.express.domain.Customer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author om95446
 */
public class CustomerServiceImplNGTest {
    
    private static CommerceExpressServices commerceExpressServices = CommerceExpressServices.getCommerceExpressServices();
    public CustomerServiceImplNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getCustomerByUsername method, of class CustomerServiceImpl.
     */
    @Test
    public void testGetCustomerByUsername() {
//        Customer customer = commerceExpressServices.getCustomerService().getCustomerByUsername("jRossouw1");
    }
}