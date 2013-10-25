/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service;

import com.commerce.express.client.web.model.CustomerModel;
import com.commerce.express.domain.Customer;
import java.util.List;

/**
 *
 * @author Owner
 */
public interface CustomerService {

    public Customer getCustomerByUsername(String username);

    public List<Customer> createCustomer(CustomerModel model);

    public List<Customer> getAllCustomer();
}
