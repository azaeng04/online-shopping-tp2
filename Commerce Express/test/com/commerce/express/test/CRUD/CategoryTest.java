/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.test.CRUD;

import com.commerce.express.app.factory.CategoryFactory;
import com.commerce.express.app.factory.ProductFactory;
import com.commerce.express.app.factory.ProductStatusFactory;
import com.commerce.express.app.factory.RatingFactory;
import com.commerce.express.domain.Category;
import com.commerce.express.domain.Product;
import com.commerce.express.domain.ProductStatus;
import com.commerce.express.domain.Rating;
import com.commerce.express.service.crud.CategoryCrudService;
import java.util.ArrayList;
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
public class CategoryTest {

    private static ApplicationContext ctx;
    private static CategoryCrudService categoryCrudService;
    private static Long categoryID;

    public CategoryTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/commerce/express/app/config/applicationContext-*.xml");
        categoryCrudService = (CategoryCrudService) ctx.getBean("CategoryCrudService");
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
    public void createCategory() {
        ProductStatus productStatus = ProductStatusFactory.getProductStatus("InStock", 100);

        Product product = new ProductFactory.Builder("7384728171")
                .setDescription("On Special")
                .setImageURL("www.google.com")
                .setProductName("Milk")
                .setProductPrice(9.95)
                .setProductStatus(productStatus)
                .buildProduct();

        Rating rating = new RatingFactory.Builder("785745")
                .setProduct(product)
                .setRatingNumber(0)
                .setRatingQuantity(0)
                .setRatingStatus("Not Rated")
                .buildRating();
        
        product.setRating(rating);
        List<Product> productList = new ArrayList<Product>();
        productList.add(product);

        Category category = CategoryFactory.getCategory("74837839482", "Dairy", productList);
        
        categoryCrudService.persist(category);
        categoryID = category.getId();

        assertNotNull(category);
    }

    @Test(dependsOnMethods = "createCategory")
    public void readCategory() {
        categoryCrudService = (CategoryCrudService) ctx.getBean("CategoryCrudService");
        Category category = categoryCrudService.findById(categoryID);

        assertNotNull(category);
    }

    @Test(dependsOnMethods = "readCategory")
    public void updateCategory() {
        Category category = categoryCrudService.findById(categoryID);
        category.setCategoryName("Pepsi");
        categoryCrudService.merge(category);

        Category category1 = categoryCrudService.findById(categoryID);
        assertEquals(category1.getCategoryName(), "Pepsi");
    }

    @Test(dependsOnMethods = "updateCategory")
    public void readCategoryS() {
        List<Category> category = categoryCrudService.findAll();

        assertTrue(category.size() > 0);
    }

    @Test(dependsOnMethods = "readCategoryS")
    public void deleteCategory() {
        Category category = categoryCrudService.findById(categoryID);
        categoryCrudService.remove(category);
        Category category1 = categoryCrudService.findById(categoryID);
        assertNull(category1);
    }
}
