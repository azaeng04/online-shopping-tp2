/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.test.dboperations;

import com.commerce.express.domain.Administrator;
import com.commerce.express.domain.Category;
import com.commerce.express.domain.Customer;
import com.commerce.express.domain.FAQ;
import com.commerce.express.service.crud.AdministratorCrudService;
import com.commerce.express.service.crud.CategoryCrudService;
import com.commerce.express.service.crud.CustomerCrudService;
import com.commerce.express.service.crud.FAQCrudService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author OM95446
 */
public class EmptyDatabase {
    
    private static ApplicationContext ctx;
    private static AdministratorCrudService administratorCrudService;
    private static CustomerCrudService customerCrudService;
    private static CategoryCrudService categoryCrudService;
    private static FAQCrudService fAQCrudService;
    
    public EmptyDatabase() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/commerce/express/app/config/applicationContext-*.xml");

        administratorCrudService = (AdministratorCrudService) ctx.getBean("AdministratorCrudService");
        customerCrudService = (CustomerCrudService) ctx.getBean("CustomerCrudService");
        categoryCrudService = (CategoryCrudService) ctx.getBean("CategoryCrudService");
        fAQCrudService = (FAQCrudService) ctx.getBean("FAQCrudService");        
    }
    
    @Test
    public void clearDB() {
        List<FAQ> faqs = fAQCrudService.findAll();
        List<Category> categories = categoryCrudService.findAll();
        List<Customer> customers = customerCrudService.findAll();
        List<Administrator> administrators = administratorCrudService.findAll();
        administratorCrudService.removeMultipleEntities(administrators);
        customerCrudService.removeMultipleEntities(customers);
        categoryCrudService.removeMultipleEntities(categories);
        fAQCrudService.removeMultipleEntities(faqs);
        System.out.println("Database EMPTIED successfully");
    }
}