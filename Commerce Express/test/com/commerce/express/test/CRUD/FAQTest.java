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
import org.testng.Assert;
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
    private Long id;
    private FAQCrudService FAQCrudService;

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
        Map<String, String> values = new HashMap<String, String>();
        values.put("question", "How Can I Pay?");
        values.put("answer", "By Eft");
        FAQ faq = FAQFactory.getFAQ(values);

        FAQCrudService = (FAQCrudService) ctx.getBean("FAQCrudService");
        FAQCrudService.persist(faq);
        id = faq.getId();

        Assert.assertNotNull(faq);
    }

    @Test(dependsOnMethods = "createFAQ")
    public void readFAQ() {
        FAQCrudService = (FAQCrudService) ctx.getBean("FAQCrudService");
        FAQ faq = FAQCrudService.findById(id);

        Assert.assertNotNull(faq);
    }

    @Test(dependsOnMethods = "readFAQ")
    public void updateFAQ() {
        FAQCrudService = (FAQCrudService) ctx.getBean("FAQCrudService");
        FAQ faq = FAQCrudService.findById(id);
        faq.setQuestion("Where is the bussiness?");
        FAQCrudService.merge(faq);

        FAQ update = FAQCrudService.findById(id);
        Assert.assertEquals(update.getQuestion(), "Where is the bussiness?");
    }

    @Test(dependsOnMethods = "updateFAQ")
    public void readFAQS() {
        FAQCrudService = (FAQCrudService) ctx.getBean("FAQCrudService");
        List<FAQ> faq = FAQCrudService.findAll();

        Assert.assertTrue(faq.size() > 0);
    }

    @Test(dependsOnMethods = "readFAQS")
    public void deleteFAQ() {
        FAQCrudService = (FAQCrudService) ctx.getBean("FAQCrudService");
        FAQ faq = FAQCrudService.findById(id);
        FAQCrudService.remove(faq);
        FAQ deleted = FAQCrudService.findById(id);
        Assert.assertNull(deleted);
    }
}