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
public class BrandTest {

    private static ApplicationContext ctx;
    private BrandCrudService BrandCrudService;
    private Long id;

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

        Map<String, String> valuesProduct = new HashMap<String, String>();
        valuesProduct.put("productName", "Milk");
        valuesProduct.put("description", "On Special");
        valuesProduct.put("imageURL", "www.google.com");

        ProductStatus productStatus = ProductStatusFactory.getProductStatus("InStock", 100);

        Product product = ProductFactory.getProduct(valuesProduct, productStatus);
        List<Product> productList = new ArrayList<Product>();
        productList.add(product);

        Map<String, String> valuesBrand = new HashMap<String, String>();
        valuesBrand.put("brandName", "Milk");
        valuesBrand.put("logoURL", "www.google.com");
        valuesBrand.put("description", "On Special");

        Brand brand = BrandFactory.getBrand(valuesBrand, productList); 
        BrandCrudService = (BrandCrudService) ctx.getBean("BrandCrudService");
        BrandCrudService.persist(brand);
        id = brand.getId();

        Assert.assertNotNull(brand);
    }

    @Test(dependsOnMethods = "createBrand")
    public void readBrand() {
        BrandCrudService = (BrandCrudService) ctx.getBean("BrandCrudService");
        Brand brand = BrandCrudService.findById(id);

        Assert.assertNotNull(brand);
    }

    @Test(dependsOnMethods = "readBrand")
    public void updateBrand() {
        BrandCrudService = (BrandCrudService) ctx.getBean("BrandCrudService");
        Brand brand = BrandCrudService.findById(id);
        brand.setBrandName("Pepsi");
        BrandCrudService.merge(brand);

        Brand update = BrandCrudService.findById(id);
        Assert.assertEquals(update.getBrandName(), "Pepsi");
    }

    @Test(dependsOnMethods = "updateBrand")
    public void readBrandS() {
        BrandCrudService = (BrandCrudService) ctx.getBean("BrandCrudService");
        List<Brand> brand = BrandCrudService.findAll();

        Assert.assertTrue(brand.size() > 0);
    }

    @Test(dependsOnMethods = "readBrandS")
    public void deleteBrand() {
        BrandCrudService = (BrandCrudService) ctx.getBean("BrandCrudService");
        Brand faq = BrandCrudService.findById(id);
        BrandCrudService.remove(faq);
        Brand deleted = BrandCrudService.findById(id);
        Assert.assertNull(deleted);
    }
}