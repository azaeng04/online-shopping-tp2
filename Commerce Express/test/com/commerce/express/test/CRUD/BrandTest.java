/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.test.CRUD;

import com.commerce.express.app.factory.BrandFactory;
import com.commerce.express.app.factory.ProductFactory;
import com.commerce.express.app.factory.ProductStatusFactory;
import com.commerce.express.domain.Brand;
import com.commerce.express.domain.Product;
import com.commerce.express.domain.ProductStatus;
import com.commerce.express.service.crud.BrandCrudService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 *
 * @author cna canal walk
 */
public class BrandTest {

    private static ApplicationContext ctx;
    private static BrandCrudService brandCrudService;
    private static Long brandID;

    public BrandTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/commerce/express/app/config/applicationContext-*.xml");
        brandCrudService = (BrandCrudService) ctx.getBean("BrandCrudService");
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
    public void createBrand() {
        ProductStatus productStatus = ProductStatusFactory.getProductStatus("InStock", 100);

        Product product = new ProductFactory.Builder("7384728171")
                .setDescription("On Special")
                .setImageURL("www.google.com")
                .setProductName("Milk")
                .setProductStatus(productStatus)
                .buildProduct();

        List<Product> productList = new ArrayList<Product>();
        productList.add(product);

        Brand brand = new BrandFactory.Builder("7384728371")
                .setBrandName("Clover")
                .setDescription("On Special")
                .setLogoURL("www.google.com")
                .setProducts(productList)
                .buildBrand();

        brandCrudService.persist(brand);
        brandID = brand.getId();

        assertNotNull(brand);
    }

    @Test(dependsOnMethods = "createBrand")
    public void readBrand() {
        Brand brand = brandCrudService.findById(brandID);

        assertNotNull(brand);
    }

    @Test(dependsOnMethods = "readBrand")
    public void updateBrand() {
        Brand brand = brandCrudService.findById(brandID);
        brand.setBrandName("Pepsi");
        brandCrudService.merge(brand);

        Brand brand1 = brandCrudService.findById(brandID);
        assertEquals(brand1.getBrandName(), "Pepsi");
    }

    @Test(dependsOnMethods = "updateBrand")
    public void readBrandS() {
        List<Brand> brand = brandCrudService.findAll();

        assertTrue(brand.size() > 0);
    }

    @Test(dependsOnMethods = "readBrandS")
    public void deleteBrand() {
        Brand brand = brandCrudService.findById(brandID);
        brandCrudService.remove(brand);
        Brand brand1 = brandCrudService.findById(brandID);
        assertNull(brand1);
    }
}