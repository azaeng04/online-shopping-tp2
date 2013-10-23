/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.impl;

import com.commerce.express.app.facade.CommerceExpressCRUD;
import com.commerce.express.app.facade.CommerceExpressServices;
import com.commerce.express.domain.Customer;
import com.commerce.express.domain.Orders;
import com.commerce.express.domain.Product;
import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 *
 * @author Ronald
 */
public class OrderServiceTest {

    CommerceExpressServices commerceExpressServices = CommerceExpressServices.getCommerceExpressServices();
    CommerceExpressCRUD commerceExpressCRUD = CommerceExpressCRUD.getCommerceExpressCRUD();

    public OrderServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getInstance method, of class OrderServiceImpl.
     */
    @Test
    public void testGetInstance() {
    }

    /**
     * Test of getOrders method, of class OrderServiceImpl.
     */
    @Test
    public void testGetOrders() {
        List<Customer> customers = commerceExpressCRUD.getCustomerCrudService().findAll();
        List<Orders> orders = commerceExpressServices.getOrderService().getOrders(customers.get(0).getUserID());

        assertTrue(orders.size() > 0);
        System.out.println("Order size: " + orders.size());
    }

    @Test
    public void getUniqueOrderNumber() {
        Integer randomNumber = commerceExpressServices.getOrderService().getUniqueOrderNumber();
        System.out.println("Order Number: " + randomNumber);
    }
    
    @Test
    public void createOrderTable() {
        List<Orders> orders = commerceExpressCRUD.getOrdersCrudService().findAll();
        
        String orderTable = commerceExpressServices.getOrderService().orderTable(orders);
        
        System.out.println(orderTable);
    }
    
    @Test
    public void getProductsOnOrder() {
        List<Orders> orders = commerceExpressCRUD.getOrdersCrudService().findAll();
        
        List<Product> products = commerceExpressServices.getOrderService().getProducts(orders.get(0).getOrderID());
        
        System.out.println(products);
    }
}