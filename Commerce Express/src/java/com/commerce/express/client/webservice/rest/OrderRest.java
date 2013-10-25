/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.client.webservice.rest;

import com.commerce.express.client.webservice.rest.assembler.OrdersAssembler;
import com.commerce.express.client.webservice.rest.resources.OrdersResource;
import com.commerce.express.domain.Orders;
import com.commerce.express.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author cna canal walk
 */
@Controller
@RequestMapping("order")
public class OrderRest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrdersAssembler ordersAssembler;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<OrdersResource>> getAppoint() {
        List<Orders> orders = orderService.getAllOrders();
        List<OrdersResource> resource = ordersAssembler.toResources(orders);
        return new ResponseEntity<List<OrdersResource>>(resource, HttpStatus.OK);
    }
}

