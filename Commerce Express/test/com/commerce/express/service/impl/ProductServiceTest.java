/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.impl;

//import static org.testng.Assert.*;
import com.commerce.express.app.facade.CommerceExpressCRUD;
import com.commerce.express.app.facade.CommerceExpressServices;
import com.commerce.express.domain.Category;
import com.commerce.express.domain.Product;
import java.util.List;
import org.springframework.context.ApplicationContext;
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
        CommerceExpressServices commerceExpressServices = CommerceExpressServices.getCommerceExpressServices();
        commerceExpressServices.getProductService().updateInStock();
    }
    
    @Test(enabled = false)
    public void testGetProducts() {
        CommerceExpressCRUD commerceExpressCRUD = CommerceExpressCRUD.getCommerceExpressCRUD();
        CommerceExpressServices commerceExpressServices = CommerceExpressServices.getCommerceExpressServices();
        List<Category> categories = commerceExpressCRUD.getCategoryCrudService().findAll();
        List<Product> products = commerceExpressServices.getProductService().getProducts(categories.get(0).getId());
        System.out.println(products);
    }
}