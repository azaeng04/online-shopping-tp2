/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.test.CRUD;

import com.commerce.express.app.factory.CategoryFactory;
import com.commerce.express.app.factory.ProductFactory;
import com.commerce.express.app.factory.ProductStatusFactory;
import com.commerce.express.domain.Category;
import com.commerce.express.domain.Product;
import com.commerce.express.domain.ProductStatus;
import com.commerce.express.service.crud.CategoryCrudService;
import java.util.ArrayList;
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
public class CategoryTest {

    private static ApplicationContext ctx;
    private CategoryCrudService CategoryCrudService;
    private Long id;

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
        Map<String, String> valuesProduct = new HashMap<String, String>();
        valuesProduct.put("productName", "Milk");
        valuesProduct.put("description", "On Special");
        valuesProduct.put("imageURL", "www.google.com");

        ProductStatus productStatus = ProductStatusFactory.getProductStatus("InStock", 100);

        Product product = ProductFactory.getProduct(valuesProduct, productStatus);
        List<Product> productList = new ArrayList<Product>();
        productList.add(product);

        Category category = CategoryFactory.getCategory("Dairy", productList);
        
        CategoryCrudService = (CategoryCrudService) ctx.getBean("CategoryCrudService");
        CategoryCrudService.persist(category);
        id = category.getId();

        Assert.assertNotNull(category);
    }

    @Test(dependsOnMethods = "createCategory")
    public void readCategory() {
        CategoryCrudService = (CategoryCrudService) ctx.getBean("CategoryCrudService");
        Category category = CategoryCrudService.findById(id);

        Assert.assertNotNull(category);
    }

    @Test(dependsOnMethods = "readCategory")
    public void updateCategory() {
        CategoryCrudService = (CategoryCrudService) ctx.getBean("CategoryCrudService");
        Category category = CategoryCrudService.findById(id);
        category.setCategoryName("Pepsi");
        CategoryCrudService.merge(category);

        Category update = CategoryCrudService.findById(id);
        Assert.assertEquals(update.getCategoryName(), "Pepsi");
    }

    @Test(dependsOnMethods = "updateCategory")
    public void readCategoryS() {
        CategoryCrudService = (CategoryCrudService) ctx.getBean("CategoryCrudService");
        List<Category> category = CategoryCrudService.findAll();

        Assert.assertTrue(category.size() > 0);
    }

    @Test(dependsOnMethods = "readCategoryS")
    public void deleteCategory() {
        CategoryCrudService = (CategoryCrudService) ctx.getBean("CategoryCrudService");
        Category faq = CategoryCrudService.findById(id);
        CategoryCrudService.remove(faq);
        Category deleted = CategoryCrudService.findById(id);
        Assert.assertNull(deleted);
    }
}
