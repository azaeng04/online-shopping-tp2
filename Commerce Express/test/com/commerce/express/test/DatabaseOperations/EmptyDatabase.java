/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.test.DatabaseOperations;

import com.commerce.express.domain.Administrator;
import com.commerce.express.domain.Brand;
import com.commerce.express.domain.Category;
import com.commerce.express.domain.Customer;
import com.commerce.express.service.crud.AdministratorCrudService;
import com.commerce.express.service.crud.BrandCrudService;
import com.commerce.express.service.crud.CategoryCrudService;
import com.commerce.express.service.crud.CustomerCrudService;
import com.commerce.express.service.crud.FAQCrudService;
import com.commerce.express.service.crud.OrdersCrudService;
import com.commerce.express.service.crud.WishListCrudService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author OM95446
 */
public class EmptyDatabase {
    
    private static ApplicationContext ctx;
    private static AdministratorCrudService administratorCrudService;
    private static CustomerCrudService customerCrudService;
    private static OrdersCrudService ordersCrudService;
    private static CategoryCrudService categoryCrudService;
    private static BrandCrudService brandCrudService;
    private static FAQCrudService fAQCrudService;
    private static WishListCrudService wishListCrudService;
    
    public EmptyDatabase() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/commerce/express/app/config/applicationContext-*.xml");

        administratorCrudService = (AdministratorCrudService) ctx.getBean("AdministratorCrudService");
        customerCrudService = (CustomerCrudService) ctx.getBean("CustomerCrudService");
        ordersCrudService = (OrdersCrudService) ctx.getBean("OrdersCrudService");
        brandCrudService = (BrandCrudService) ctx.getBean("BrandCrudService");
        wishListCrudService = (WishListCrudService) ctx.getBean("WishListCrudService");
        categoryCrudService = (CategoryCrudService) ctx.getBean("CategoryCrudService");
        fAQCrudService = (FAQCrudService) ctx.getBean("FAQCrudService");        
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
    
    @Test
    public void clearDB() {
        List<Brand> brands = brandCrudService.findAll();
        List<Category> categories = categoryCrudService.findAll();
        List<Customer> customers = customerCrudService.findAll();
        List<Administrator> administrators = administratorCrudService.findAll();
        administratorCrudService.removeMultipleEntities(administrators);
        customerCrudService.removeMultipleEntities(customers);
        categoryCrudService.removeMultipleEntities(categories);
        brandCrudService.removeMultipleEntities(brands);
        System.out.println("Database EMPTIED successfully");
    }
}