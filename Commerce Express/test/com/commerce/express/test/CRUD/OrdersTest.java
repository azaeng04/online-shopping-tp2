/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.test.CRUD;

import com.commerce.express.app.factory.CategoryFactory;
import com.commerce.express.app.factory.OrderLineFactory;
import com.commerce.express.app.factory.OrdersFactory;
import com.commerce.express.app.factory.ProductFactory;
import com.commerce.express.app.factory.ProductStatusFactory;
import com.commerce.express.domain.Category;
import com.commerce.express.domain.OrderLine;
import com.commerce.express.domain.Orders;
import com.commerce.express.domain.Product;
import com.commerce.express.domain.ProductStatus;
import com.commerce.express.service.crud.CategoryCrudService;
import com.commerce.express.service.crud.OrdersCrudService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;
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
public class OrdersTest {

    private static ApplicationContext ctx;
    private static OrdersCrudService ordersCrudService;
    private static CategoryCrudService categoryCrudService;
    private static Long categoryID;
    private static Long orderID;
    
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
        ordersCrudService = (OrdersCrudService) ctx.getBean("OrdersCrudService");
        categoryCrudService = (CategoryCrudService) ctx.getBean("CategoryCrudService");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        Category category = categoryCrudService.findById(categoryID);
        categoryCrudService.remove(category);
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    @Test
    public void createOrders() {        
        ProductStatus productStatus = ProductStatusFactory.getProductStatus("InStock", 100);

        Product product = new ProductFactory.Builder("7384728171")
                .setDescription("On Special")
                .setImageURL("www.google.com")
                .setProductName("Milk")
                .setProductStatus(productStatus)
                .buildProduct();

        List<Product> productList = new ArrayList<Product>();
        productList.add(product);

        Category category = CategoryFactory.getCategory("74837839482", "Dairy", productList);
        
        categoryCrudService.persist(category);
        categoryID = category.getId();
        
        assertNotNull(category);
        
        OrderLine orderLine = OrderLineFactory.getOrderLine("748374828", 100, product);
        List<OrderLine> ordersList = new ArrayList<OrderLine>();
        ordersList.add(orderLine);
        
        Date date = new DateTime(2012, 12, 27, 0, 0).toDate();
        Orders orders = new OrdersFactory.Builder("8394829381")
                .setDateCreated(date)
                .setDateModified(date)
                .setOrderLines(ordersList)
                .setStatus("Available")
                .buildOrder();               
        
        ordersCrudService.persist(orders);
        orderID = orders.getId();

        assertNotNull(orders);
    }

    @Test(dependsOnMethods = "createOrders")
    public void readOrders() {
        Orders orders = ordersCrudService.findById(orderID);

        assertNotNull(orders);
    }

    @Test(dependsOnMethods = "readOrders")
    public void updateOrders() {
        Orders orders = ordersCrudService.findById(orderID);
        orders.setStatus("In Stock");
        ordersCrudService.merge(orders);

        Orders orders1 = ordersCrudService.findById(orderID);
        assertEquals(orders1.getStatus(),"In Stock");
    }

    @Test(dependsOnMethods = "updateOrders")
    public void readOrdersS() {
        List<Orders> orders = ordersCrudService.findAll();

        assertTrue(orders.size() > 0);
    }

    @Test(dependsOnMethods = "readOrdersS")
    public void deleteOrders() {
        Orders orders = ordersCrudService.findById(orderID);
        ordersCrudService.remove(orders);
        Orders orders1 = ordersCrudService.findById(orderID);
        assertNull(orders1);
    }   
    
}