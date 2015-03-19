/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.factory;

import com.commerce.express.domain.OrderLine;
import com.commerce.express.domain.Product;

/**
 *
 * @author cna canal walk
 */
public class OrderLineFactory {

    private OrderLineFactory() {
    }

    public static OrderLine getOrderLine(String orderLineID, Integer quantity, Product product) {
        OrderLine orderline = new OrderLine();
        orderline.setOrderLineID("ORL_" + orderLineID);
        orderline.setQuantity(quantity);
        orderline.setProduct(product);
        return orderline;
    }
}
