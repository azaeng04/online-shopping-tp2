/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.impl;

import com.commerce.express.service.OrderService;
import com.commerce.express.service.crud.OrdersCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Owner
 */
@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersCrudService orderCrudService;
    private static OrderServiceImpl orderServiceImpl;
    
    private OrderServiceImpl() {
    }
    
    public synchronized static OrderServiceImpl getInstance() {
        if (orderServiceImpl == null) {
            orderServiceImpl = new OrderServiceImpl();
        }
        return orderServiceImpl;
    }
}