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

    public static OrderLine getOrderLine(int quantity,Product product) {
        OrderLine orderline = new OrderLine();
        orderline.setQuantity(quantity);
        orderline.setProduct(null);
        return orderline;
    }
}
