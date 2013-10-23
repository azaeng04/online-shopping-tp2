/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.impl;

import com.commerce.express.app.facade.CommerceExpressCRUD;
import com.commerce.express.app.facade.CommerceExpressServices;
import com.commerce.express.domain.OrderLine;
import com.commerce.express.service.OrderLineService;
import java.util.Random;
import org.springframework.stereotype.Service;

/**
 *
 * @author Owner
 */
@Service("OrderLineService")
public class OrderLineServiceImpl implements OrderLineService {

    private static CommerceExpressCRUD commerceExpressCRUD = CommerceExpressCRUD.getCommerceExpressCRUD();
    private static CommerceExpressServices commerceExpressServices = CommerceExpressServices.getCommerceExpressServices();
    private static OrderLineServiceImpl orderLineServiceImpl;

    private OrderLineServiceImpl() {
    }

    public synchronized static OrderLineServiceImpl getInstance() {
        if (orderLineServiceImpl == null) {
            orderLineServiceImpl = new OrderLineServiceImpl();
        }
        return orderLineServiceImpl;
    }

    @Override
    public Integer getUniqueOrderLineNumber() {
        Random random = new Random();
        Integer randomNumber = commerceExpressServices.getGeneralService().generateRandomNumber(10000, 99999, random);
        OrderLine orderLine;
        Boolean isFound = true;
        while (isFound) {
            orderLine = commerceExpressCRUD.getOrderLineCrudService().getByPropertyName("orderLineID", "ORL_" + randomNumber);
            if (orderLine != null) {
                randomNumber = commerceExpressServices.getGeneralService().generateRandomNumber(10000, 99999, random);
            } else {
                isFound = false;
            }
        }
        return randomNumber;
    }
}