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
import org.testng.annotations.Test;

/**
 *
 * @author Ronald
 */
public class ProductServiceTest {

    private static final CommerceExpressServices commerceExpressServices = CommerceExpressServices.getCommerceExpressServices();
    private static final CommerceExpressCRUD commerceExpressCRUD = CommerceExpressCRUD.getCommerceExpressCRUD();
    
    public ProductServiceTest() {
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