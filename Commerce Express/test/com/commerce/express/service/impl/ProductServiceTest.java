/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.impl;

//import static org.testng.Assert.*;
import com.commerce.express.app.facade.CommerceExpressCRUD;
import com.commerce.express.app.facade.CommerceExpressServices;
import com.commerce.express.domain.Category;
import com.commerce.express.domain.OrderLine;
import com.commerce.express.domain.Orders;
import com.commerce.express.domain.Product;
import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Ronald
 */
public class ProductServiceTest {

    CommerceExpressServices commerceExpressServices = CommerceExpressServices.getCommerceExpressServices();
    CommerceExpressCRUD commerceExpressCRUD = CommerceExpressCRUD.getCommerceExpressCRUD();
    
    public ProductServiceTest() {
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
     * Test of getInstance method, of class ProductServiceImpl.
     */
    @Test
    public void testGetInstance() {
    }

    /**
     * Test of updateInStock method, of class ProductServiceImpl.
     */
    @Test
    public void testUpdateInStock() {
        List<Orders> orders = commerceExpressCRUD.getOrdersCrudService().findAll();
        Orders orders1 = orders.get(0);
        List<OrderLine> orderLines = commerceExpressServices.getOrderService().getOrderLine(orders1.getOrderID());
        System.out.println("Before");
        for (OrderLine orderLine : orderLines) {
            Product product = orderLine.getProduct();
            System.out.println("Product ID: " + product.getProductID());
            System.out.println("Quantity: " + orderLine.getQuantity());
            System.out.println("In Stock: " + product.getProductStatus().getInStock());
        }
        
        commerceExpressServices.getProductService().updateInStock(orders1.getOrderID());
        
        System.out.println("After");
        orderLines = commerceExpressServices.getOrderService().getOrderLine(orders1.getOrderID());
        for (OrderLine orderLine : orderLines) {
            Product product = orderLine.getProduct();
            System.out.println("Product ID: " + product.getProductID());
            System.out.println("Quantity: " + orderLine.getQuantity());
            System.out.println("In Stock: " + product.getProductStatus().getInStock());
        }
    }

    @Test(enabled = false)
    public void testGetProducts() {
        List<Category> categories = commerceExpressCRUD.getCategoryCrudService().findAll();
        List<Product> products = commerceExpressServices.getProductService().getProducts(categories.get(0).getId());
        System.out.println(products);
    }
}