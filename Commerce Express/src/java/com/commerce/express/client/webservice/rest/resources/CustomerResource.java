/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.client.webservice.rest.resources;

import com.commerce.express.domain.Category;
import com.commerce.express.domain.Customer;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author cna canal walk
 */
public class CustomerResource extends ResourceSupport {

    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
