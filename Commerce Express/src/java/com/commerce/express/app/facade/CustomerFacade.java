/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.facade;

import com.commerce.express.app.config.GetContext;
import com.commerce.express.service.crud.CustomerCrudService;
import com.commerce.express.service.crud.OrderLineCrudService;
import com.commerce.express.service.crud.OrdersCrudService;
import java.io.Serializable;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Ronalds
 */
public class CustomerFacade implements Serializable {
    private static CustomerFacade customerFacade;
    private final static ApplicationContext ctx = GetContext.getApplicationContext();
    private CustomerCrudService customerCrudService;
    private OrdersCrudService ordersCrudService;
    private OrderLineCrudService orderLineCrudService;

    private CustomerFacade() {
    }

    public static synchronized CustomerFacade getCustomerFacadeInstance(){
        if (customerFacade == null) {
            customerFacade = new CustomerFacade();
        }
        return customerFacade;
    }
    
    public OrdersCrudService getOrdersCrudService() {
        ordersCrudService = (OrdersCrudService) ctx.getBean("OrdersCrudService");
        return ordersCrudService;
    }
    
    public CustomerCrudService getCustomerCrudService() {
        customerCrudService = (CustomerCrudService) ctx.getBean("CustomerCrudService");
        return customerCrudService;
    }
    
    public OrderLineCrudService getOrderLineCrudService() {
        orderLineCrudService = (OrderLineCrudService) ctx.getBean("OrderLineCrudService");
        return orderLineCrudService;
    }
}
