/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.test.CRUD;

import com.commerce.express.app.factory.FAQFactory;
import com.commerce.express.domain.FAQ;
import com.commerce.express.service.crud.FAQCrudService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author cna canal walk
 */
public class FAQTest {

    private static ApplicationContext ctx;
    private static Long faqID;
    private static FAQCrudService fAQCrudService;

    public FAQTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/commerce/express/app/config/applicationContext-*.xml");
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
    public void createFAQ() {
        FAQ faq = FAQFactory.getFAQ("748374827", "How Can I Pay?", "By EFT");
        
        fAQCrudService.persist(faq);
        faqID = faq.getId();

        assertNotNull(faq);
    }

    @Test(dependsOnMethods = "createFAQ")
    public void readFAQ() {
        FAQ faq = fAQCrudService.findById(faqID);

        assertNotNull(faq);
    }

    @Test(dependsOnMethods = "readFAQ")
    public void updateFAQ() {
        FAQ faq = fAQCrudService.findById(faqID);
        faq.setQuestion("Where is the bussiness?");
        fAQCrudService.merge(faq);

        FAQ update = fAQCrudService.findById(faqID);
        assertEquals(update.getQuestion(), "Where is the bussiness?");
    }

    @Test(dependsOnMethods = "updateFAQ")
    public void readFAQS() {
        List<FAQ> faq = fAQCrudService.findAll();

        assertTrue(faq.size() > 0);
    }

    @Test(dependsOnMethods = "readFAQS")
    public void deleteFAQ() {
        FAQ faq = fAQCrudService.findById(faqID);
        fAQCrudService.remove(faq);
        FAQ deleted = fAQCrudService.findById(faqID);
        assertNull(deleted);
    }
}