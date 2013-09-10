/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.factory;

import com.commerce.express.domain.Customer;

/**
 *
 * @author cna canal walk
 */
public class CustomerFactory {

    public static Customer getCustomer() {
        Customer customer = new Customer();

        return customer;
    }
}
