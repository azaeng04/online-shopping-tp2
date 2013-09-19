/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.test.CRUD;

import com.commerce.express.app.factory.ProductFactory;
import com.commerce.express.app.factory.ProductStatusFactory;
import com.commerce.express.app.factory.WishListFactory;
import com.commerce.express.domain.Product;
import com.commerce.express.domain.ProductStatus;
import com.commerce.express.domain.WishList;
import com.commerce.express.service.crud.WishListCrudService;
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
public class WishListTest {

    private static ApplicationContext ctx;
    private WishListCrudService WishListCrudService;
    private Long id;

    public WishListTest() {
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
    public void createWishList() {

        Map<String, String> valuesProduct = new HashMap<String, String>();
        valuesProduct.put("productName", "Milk");
        valuesProduct.put("description", "On Special");
        valuesProduct.put("imageURL", "www.google.com");

        ProductStatus productStatus = ProductStatusFactory.getProductStatus("InStock", 100);

        Product product = ProductFactory.getProduct(valuesProduct, productStatus);
        List<Product> productList = new ArrayList<Product>();
        productList.add(product);

        Date dateCreated = new DateTime(2012, 12, 26, 0, 0).toDate();
        Date dateModified = new DateTime(2012, 12, 27, 0, 0).toDate();

        WishList wishList = WishListFactory.getWishList(dateCreated, dateModified, 100, productList);

        WishListCrudService = (WishListCrudService) ctx.getBean("WishListCrudService");
        WishListCrudService.persist(wishList);
        id = wishList.getId();

        Assert.assertNotNull(wishList);
    }

    @Test(dependsOnMethods = "createWishList")
    public void readWishList() {
        WishListCrudService = (WishListCrudService) ctx.getBean("WishListCrudService");
        WishList wishList = WishListCrudService.findById(id);

        Assert.assertNotNull(wishList);
    }

    @Test(dependsOnMethods = "readWishList")
    public void updateWishList() {
        WishListCrudService = (WishListCrudService) ctx.getBean("WishListCrudService");
        WishList wishList = WishListCrudService.findById(id);
        Date dateCreated = new DateTime(2012, 11, 26, 0, 0).toDate();
        wishList.setDateCreated(dateCreated);
        WishListCrudService.merge(wishList);

        WishList update = WishListCrudService.findById(id);
        
        Assert.assertEquals(update.getDateCreated(), dateCreated);
    }

    @Test(dependsOnMethods = "updateWishList")
    public void readWishListS() {
        WishListCrudService = (WishListCrudService) ctx.getBean("WishListCrudService");
        List<WishList> wishList = WishListCrudService.findAll();

        Assert.assertTrue(wishList.size() > 0);
    }

    @Test(dependsOnMethods = "readWishListS")
    public void deleteWishList() {
        WishListCrudService = (WishListCrudService) ctx.getBean("WishListCrudService");
        WishList faq = WishListCrudService.findById(id);
        WishListCrudService.remove(faq);
        WishList deleted = WishListCrudService.findById(id);
        Assert.assertNull(deleted);
    }
}