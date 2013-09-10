/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.factory;

import com.commerce.express.domain.OrderLine;
import com.commerce.express.domain.Orders;
import java.util.Date;
import java.util.List;

/**
 *
 * @author cna canal walk
 */
public class OrdersFactory {

    public static Orders getOrders(Date dateCreated, List<OrderLine> orderLine) {
        Orders orders = new Orders();
        orders.setDateCreated(dateCreated);
        orders.setOrderLines(orderLine);
        return orders;
    }
}