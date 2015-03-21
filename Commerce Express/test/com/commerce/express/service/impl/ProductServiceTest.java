package com.commerce.express.service.impl;

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

    private static final CommerceExpressServices CE_SERVICES = CommerceExpressServices.getCommerceExpressServices();
    private static final CommerceExpressCRUD CE_CRUDS = CommerceExpressCRUD.getCommerceExpressCRUD();
    
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
        List<Orders> orders = CE_CRUDS.getOrdersCrudService().findAll();
        Orders orders1 = orders.get(0);
        List<OrderLine> orderLines = CE_SERVICES.getOrderService().getOrderLine(orders1.getOrderID());
        System.out.println("Before");
        for (OrderLine orderLine : orderLines) {
            Product product = orderLine.getProduct();
            System.out.println("Product ID: " + product.getProductID());
            System.out.println("Quantity: " + orderLine.getQuantity());
            System.out.println("In Stock: " + product.getProductStatus().getInStock());
        }
        
        CE_SERVICES.getProductService().updateInStock(orders1.getOrderID());
        
        System.out.println("After");
        orderLines = CE_SERVICES.getOrderService().getOrderLine(orders1.getOrderID());
        for (OrderLine orderLine : orderLines) {
            Product product = orderLine.getProduct();
            System.out.println("Product ID: " + product.getProductID());
            System.out.println("Quantity: " + orderLine.getQuantity());
            System.out.println("In Stock: " + product.getProductStatus().getInStock());
        }
    }

    @Test(enabled = false)
    public void testGetProducts() {
        List<Category> categories = CE_CRUDS.getCategoryCrudService().findAll();
        List<Product> products = CE_SERVICES.getProductService().getProducts(categories.get(0).getId());
        System.out.println(products);
    }
}