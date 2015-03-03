/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.test.resttests;

import com.commerce.express.client.webservice.rest.resources.ProductResource;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.web.client.RestTemplate;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author aengelbrecht
 */
public class RestTest {

    private static final String BASE_URI = "http://localhost:8080/Commerce_Express/";

    public RestTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void hello() {
        RestTemplate restTemplate = new RestTemplate();

        try {
            List<ProductResource> productResources = restTemplate.getForObject(BASE_URI + "products", List.class);

            Iterator product = productResources.iterator();
            while (product.hasNext()) {
                System.out.println("" + product.hashCode());
                product.next();
            }
        } catch (Exception ex) {
            fail("Exception: " + ex.getMessage());
        }
    }

    @Test(enabled = false)
    public void testRESTProduct() {
        RestTemplate restTemplate = new RestTemplate();

        try {

            List<ProductResource> productResources = restTemplate.getForObject(BASE_URI + "product/650", List.class);

            Iterator product = productResources.iterator();
            while (product.hasNext()) {
                System.out.println("" + product.hashCode());
                product.next();
            }
        } catch (Exception ex) {
            fail("Exception: " + ex.getMessage());
        }
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
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
}
