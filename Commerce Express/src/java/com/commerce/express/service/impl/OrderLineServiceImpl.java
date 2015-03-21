package com.commerce.express.service.impl;

import com.commerce.express.app.facade.CommerceExpressCRUD;
import com.commerce.express.app.facade.CommerceExpressServices;
import com.commerce.express.domain.OrderLine;
import com.commerce.express.service.OrderLineService;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

/**
 *
 * @author Owner
 */
@Service("OrderLineService")
public class OrderLineServiceImpl implements OrderLineService {

    private static final CommerceExpressCRUD CE_CRUDS = CommerceExpressCRUD.getCommerceExpressCRUD();
    private static final CommerceExpressServices CE_SERVICES = CommerceExpressServices.getCommerceExpressServices();
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
        Integer randomNumber = CE_SERVICES.getGeneralService().generateRandomNumber(10000, 99999, random);
        OrderLine orderLine;
        Boolean isFound = true;
        while (isFound) {
            orderLine = CE_CRUDS.getOrderLineCrudService().getByPropertyName("orderLineID", "ORL_" + randomNumber);
            if (orderLine != null) {
                randomNumber = CE_SERVICES.getGeneralService().generateRandomNumber(10000, 99999, random);
            } else {
                isFound = false;
            }
        }
        return randomNumber;
    }

    @Override
    public List<OrderLine> getAllOrderLine() {
        return CE_CRUDS.getOrderLineCrudService().findAll();
    }
}