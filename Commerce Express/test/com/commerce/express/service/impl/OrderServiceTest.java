package com.commerce.express.service.impl;

import com.commerce.express.app.facade.CommerceExpressCRUD;
import com.commerce.express.app.facade.CommerceExpressServices;
import com.commerce.express.domain.Customer;
import com.commerce.express.domain.Orders;
import com.commerce.express.domain.Product;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 *
 * @author Ronald
 */
public class OrderServiceTest {

    private static final CommerceExpressServices CE_SERVICES = CommerceExpressServices.getCommerceExpressServices();
    private static final CommerceExpressCRUD CE_CRUDS = CommerceExpressCRUD.getCommerceExpressCRUD();

    public OrderServiceTest() {
    }
    
    /**
     * Test of getOrders method, of class OrderServiceImpl.
     */
    @Test
    public void testGetOrders() {
        List<Customer> customers = CE_CRUDS.getCustomerCrudService().findAll();
        List<Orders> orders = CE_SERVICES.getOrderService().getOrders(customers.get(0).getUserID());

        assertTrue(!orders.isEmpty());
        System.out.println("Order size: " + orders.size());
    }

    @Test
    public void getUniqueOrderNumber() {
        Integer randomNumber = CE_SERVICES.getOrderService().getUniqueOrderNumber();
        System.out.println("Order Number: " + randomNumber);
    }
    
    @Test
    public void createOrderTable() {
        List<Orders> orders = CE_CRUDS.getOrdersCrudService().findAll();
        
        String orderTable = CE_SERVICES.getOrderService().orderTable(orders);
        
        System.out.println(orderTable);
    }
    
    @Test
    public void getProductsOnOrder() {
        List<Orders> orders = CE_CRUDS.getOrdersCrudService().findAll();
        
        List<Product> products = CE_SERVICES.getOrderService().getProducts(orders.get(0).getOrderID());
        
        System.out.println(products);
    }
}