/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service;

import com.commerce.express.domain.Customer;

/**
 *
 * @author Owner
 */
public interface CustomerService {
    public Customer getCustomerByUsername(String username);
}
