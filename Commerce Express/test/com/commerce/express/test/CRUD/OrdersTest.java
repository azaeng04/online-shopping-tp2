/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.test.CRUD;

import com.commerce.express.app.factory.OrderLineFactory;
import com.commerce.express.app.factory.OrdersFactory;
import com.commerce.express.app.factory.ProductFactory;
import com.commerce.express.app.factory.ProductStatusFactory;
import com.commerce.express.domain.OrderLine;
import com.commerce.express.domain.Orders;
import com.commerce.express.domain.Product;
import com.commerce.express.domain.ProductStatus;
import com.commerce.express.service.crud.OrdersCrudService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.joda.time.DateTime;
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
public class OrdersTest {

    private static ApplicationContext ctx;
    private OrdersCrudService OrdersCrudService;
    private Long id;
    
    public OrdersTest() {
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
    public void createOrders() {
        
        Map<String, String> valuesProduct = new HashMap<String, String>();
        valuesProduct.put("productName", "Milk");
        valuesProduct.put("description", "On Special");
        valuesProduct.put("imageURL", "www.google.com");

        ProductStatus productStatus = ProductStatusFactory.getProductStatus("InStock", 100);

        Product product = ProductFactory.getProduct(valuesProduct, productStatus);

        OrderLine orderLine = OrderLineFactory.getOrderLine(100, product);
        List<OrderLine> ordersList = new ArrayList<OrderLine>();
        ordersList.add(orderLine);
        
        Date date = new DateTime(2012, 12, 27, 0, 0).toDate();
        Orders orders = OrdersFactory.getOrders(date, ordersList);
               
        OrdersCrudService = (OrdersCrudService) ctx.getBean("OrdersCrudService");
        OrdersCrudService.persist(orders);
        id = orders.getId();

        Assert.assertNotNull(orders);
    }

    @Test(dependsOnMethods = "createOrders")
    public void readOrders() {
        OrdersCrudService = (OrdersCrudService) ctx.getBean("OrdersCrudService");
        Orders orders = OrdersCrudService.findById(id);

        Assert.assertNotNull(orders);
    }

    @Test(dependsOnMethods = "readOrders")
    public void updateOrders() {
        OrdersCrudService = (OrdersCrudService) ctx.getBean("OrdersCrudService");
        Orders orders = OrdersCrudService.findById(id);
        orders.setStatus("In Stock");
        OrdersCrudService.merge(orders);

        Orders update = OrdersCrudService.findById(id);
        Assert.assertEquals(update.getStatus(),"In Stock");
    }

    @Test(dependsOnMethods = "updateOrders")
    public void readOrdersS() {
        OrdersCrudService = (OrdersCrudService) ctx.getBean("OrdersCrudService");
        List<Orders> orders = OrdersCrudService.findAll();

        Assert.assertTrue(orders.size() > 0);
    }

    @Test(dependsOnMethods = "readOrdersS")
    public void deleteOrders() {
        OrdersCrudService = (OrdersCrudService) ctx.getBean("OrdersCrudService");
        Orders faq = OrdersCrudService.findById(id);
        OrdersCrudService.remove(faq);
        Orders deleted = OrdersCrudService.findById(id);
        Assert.assertNull(deleted);
    }   
    
}