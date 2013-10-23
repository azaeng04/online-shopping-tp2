/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.impl;

import com.commerce.express.app.facade.CommerceExpressCRUD;
import com.commerce.express.client.web.model.CustomerModel;
import com.commerce.express.domain.AccessDetails;
import com.commerce.express.domain.Customer;
import com.commerce.express.service.CustomerService;
import com.commerce.express.service.crud.CustomerCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Owner
 */
@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

    private static CommerceExpressCRUD commerceExpressCRUD = CommerceExpressCRUD.getCommerceExpressCRUD();
    private static CustomerServiceImpl customerServiceImpl;
    @Autowired
    private CustomerCrudService customerCrudService;

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
        AccessDetails accessDetails = commerceExpressCRUD.getAccessDetailsCrudService().getByPropertyName("username", username);
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

    @Override
    public List<Customer> createCustomer(CustomerModel model) {

        Customer cust = new Customer();

        cust.setUserID(model.getUserID());
        cust.setAccessDetails(null);
        cust.setAddresses(null);
        cust.setContact(null);
        cust.setDateOfBirth(model.getDateOfBirth());
        cust.setFirstName(model.getFirstName());
        cust.setGender(model.getGender());
        cust.setLastName(model.getLastName());
        cust.setMiddleName(model.getMiddleName());

        customerCrudService.persist(cust);
        return customerCrudService.findAll();
    }
}