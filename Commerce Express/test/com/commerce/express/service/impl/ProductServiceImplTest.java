/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.impl;

//import static org.testng.Assert.*;
import com.commerce.express.app.facade.CategoryFacade;
import com.commerce.express.domain.Category;
import com.commerce.express.domain.Product;
import com.commerce.express.service.ProductService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Ronald
 */
public class ProductServiceImplTest {

    private static ApplicationContext ctx;
    private static ProductService productService;
    
    public ProductServiceImplTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/commerce/express/app/config/applicationContext-*.xml");
        productService = (ProductService) ctx.getBean("ProductService");
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
        productService.updateInStock();
    }
    
    @Test(enabled = false)
    public void testGetProducts() {
        CategoryFacade categoryFacade = CategoryFacade.getCategoryFacadeInstance();
        List<Category> categories = categoryFacade.getCategoryCrudService().findAll();
        List<Product> products = productService.getProducts(categories.get(0).getId());
        System.out.println(products);
    }
}