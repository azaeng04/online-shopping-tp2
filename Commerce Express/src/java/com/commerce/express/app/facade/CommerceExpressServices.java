/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.facade;

import com.commerce.express.app.config.GetContext;
import com.commerce.express.service.AccessDetailsService;
import com.commerce.express.service.AdministratorService;
import com.commerce.express.service.CustomerService;
import com.commerce.express.service.OrderService;
import com.commerce.express.service.ProductService;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author om95446
 */
public class CommerceExpressServices {
    private static CommerceExpressServices commerceExpressServices;
    private final static ApplicationContext ctx = GetContext.getApplicationContext();
    private static AccessDetailsService accessDetailsService;
    private static AdministratorService administratorService;
    private static CustomerService customerService;
    private static OrderService orderService;
    private static ProductService productService;
    
    private CommerceExpressServices() {
    }

    public static synchronized CommerceExpressServices getCommerceExpressServices(){
        if (commerceExpressServices == null) {
            commerceExpressServices = new CommerceExpressServices();
        }
        return commerceExpressServices;
    }
    
    public AccessDetailsService getAccessDetailsService() {
        accessDetailsService = (AccessDetailsService) ctx.getBean("AccessDetailsService");
        return accessDetailsService;
    }
    
    public AdministratorService getAdministratorService() {
        administratorService = (AdministratorService) ctx.getBean("AdministratorService");
        return administratorService;
    }
    
    public CustomerService getCustomerService() {
        customerService = (CustomerService) ctx.getBean("CustomerService");
        return customerService;
    }
    
    public OrderService getOrderService() {
        orderService = (OrderService) ctx.getBean("OrderService");
        return orderService;
    }
    
    public ProductService getProductService() {
        productService = (ProductService) ctx.getBean("ProductService");
        return productService;
    }
}
