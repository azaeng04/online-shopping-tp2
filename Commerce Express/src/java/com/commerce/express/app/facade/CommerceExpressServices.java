package com.commerce.express.app.facade;

import com.commerce.express.app.config.GetContext;
import com.commerce.express.service.AccessDetailsService;
import com.commerce.express.service.AdministratorService;
import com.commerce.express.service.CartService;
import com.commerce.express.service.CustomerService;
import com.commerce.express.service.GeneralService;
import com.commerce.express.service.OrderLineService;
import com.commerce.express.service.OrderService;
import com.commerce.express.service.ProductService;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author om95446
 */
public class CommerceExpressServices {
    private static CommerceExpressServices commerceExpressServices;
    private final static ApplicationContext CTX = GetContext.getApplicationContext();
    private static AccessDetailsService accessDetailsService;
    private static AdministratorService administratorService;
    private static CustomerService customerService;
    private static OrderService orderService;
    private static OrderLineService orderLineService;
    private static ProductService productService;
    private static CartService cartService;
    private static GeneralService generalService;
    
    private CommerceExpressServices() {
    }

    public static synchronized CommerceExpressServices getCommerceExpressServices(){
        if (commerceExpressServices == null) {
            commerceExpressServices = new CommerceExpressServices();
        }
        return commerceExpressServices;
    }
    
    public GeneralService getGeneralService() {
        generalService = (GeneralService) CTX.getBean("GeneralService");
        return generalService;
    }
    
    public CartService getCartService() {
        cartService = (CartService) CTX.getBean("CartService");
        return cartService;
    }
    
    public OrderLineService getOrderLineService() {
        orderLineService = (OrderLineService) CTX.getBean("OrderLineService");
        return orderLineService;
    }
    
    public AccessDetailsService getAccessDetailsService() {
        accessDetailsService = (AccessDetailsService) CTX.getBean("AccessDetailsService");
        return accessDetailsService;
    }
    
    public AdministratorService getAdministratorService() {
        administratorService = (AdministratorService) CTX.getBean("AdministratorService");
        return administratorService;
    }
    
    public CustomerService getCustomerService() {
        customerService = (CustomerService) CTX.getBean("CustomerService");
        return customerService;
    }
    
    public OrderService getOrderService() {
        orderService = (OrderService) CTX.getBean("OrderService");
        return orderService;
    }
    
    public ProductService getProductService() {
        productService = (ProductService) CTX.getBean("ProductService");
        return productService;
    }
}
