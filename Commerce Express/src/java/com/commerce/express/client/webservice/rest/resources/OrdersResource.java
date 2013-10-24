/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.client.webservice.rest.resources;

import com.commerce.express.domain.Orders;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author cna canal walk
 */
public class OrdersResource extends ResourceSupport {

    private Orders orders;

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
