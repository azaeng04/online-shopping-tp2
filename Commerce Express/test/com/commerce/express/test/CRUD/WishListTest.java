/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.test.CRUD;

import com.commerce.express.app.factory.CategoryFactory;
import com.commerce.express.app.factory.ProductFactory;
import com.commerce.express.app.factory.ProductStatusFactory;
import com.commerce.express.app.factory.WishListFactory;
import com.commerce.express.app.factory.WishListLineFactory;
import com.commerce.express.domain.Category;
import com.commerce.express.domain.Product;
import com.commerce.express.domain.ProductStatus;
import com.commerce.express.domain.WishList;
import com.commerce.express.domain.WishListLine;
import com.commerce.express.service.crud.CategoryCrudService;
import com.commerce.express.service.crud.WishListCrudService;
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
public class WishListTest {

    private static ApplicationContext ctx;
    private static WishListCrudService wishListCrudService;
    private static CategoryCrudService categoryCrudService;
    private static Long categoryID;
    private static Long wishListID;

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
        wishListCrudService = (WishListCrudService) ctx.getBean("WishListCrudService");
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
    public void createWishList() {
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

        assertNotNull(category);

        WishListLine wishListLine = WishListLineFactory.getWishListLine("748374828", 100, product);
        List<WishListLine> wishListLines = new ArrayList<WishListLine>();
        wishListLines.add(wishListLine);

        Date date = new DateTime().toDate();
        WishList wishList = WishListFactory.getWishList("78374892213", date, date, wishListLines);                

        wishListCrudService.persist(wishList);
        wishListID = wishList.getId();
        
        assertNotNull(wishList);
    }

    @Test(dependsOnMethods = "createWishList")
    public void readWishList() {
        WishList wishList = wishListCrudService.findById(wishListID);

        assertNotNull(wishList);
    }

    @Test(dependsOnMethods = "readWishList")
    public void updateWishList() {
        WishList wishList = wishListCrudService.findById(wishListID);
        wishList.setWishListID("7845793475789");
        wishListCrudService.merge(wishList);

        WishList wishList1 = wishListCrudService.findById(wishListID);

        assertEquals(wishList1.getWishListID(), "7845793475789");
    }

    @Test(dependsOnMethods = "updateWishList")
    public void readWishListS() {
        List<WishList> wishList = wishListCrudService.findAll();

        assertTrue(wishList.size() > 0);
    }

    @Test(dependsOnMethods = "readWishListS")
    public void deleteWishList() {
        WishList wishList = wishListCrudService.findById(wishListID);
        wishListCrudService.remove(wishList);
        WishList wishList1 = wishListCrudService.findById(wishListID);
        assertNull(wishList1);
    }
}