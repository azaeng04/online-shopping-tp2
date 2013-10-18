/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.impl;

import com.commerce.express.app.facade.CommerceExpressCRUD;
import com.commerce.express.domain.AccessDetails;
import com.commerce.express.domain.Customer;
import com.commerce.express.service.CustomerService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Owner
 */
@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

    private static CommerceExpressCRUD commerceExpressCRUD = CommerceExpressCRUD.getCommerceExpressCRUD();
    private static CustomerServiceImpl customerServiceImpl;
    
    private CustomerServiceImpl() {
    }
    
    public synchronized static CustomerServiceImpl getInstance() {
        if (customerServiceImpl == null) {
            customerServiceImpl = new CustomerServiceImpl();
        }
        return customerServiceImpl;
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        AccessDetails accessDetails = commerceExpressCRUD.getAccessDetailsCrudService().getByPropertyName("USERNAME", username);
        List<Customer> customers = commerceExpressCRUD.getCustomerCrudService().findAll();
        Customer customer1 = new Customer();
        for (Customer customer : customers) {
            if (customer.getAccessDetails().equals(accessDetails)) {
                customer1 = customer;
                break;
            }
        }
        return customer1;
    }
}