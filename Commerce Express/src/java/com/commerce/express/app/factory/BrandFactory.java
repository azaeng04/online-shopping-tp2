/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.factory;

import com.commerce.express.domain.Brand;
import com.commerce.express.domain.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author cna canal walk
 */
public class BrandFactory {

    public static Brand getBrand(Map<String, String> values, List<Product> product) {
        Brand brand = new Brand();
        brand.setBrandName(values.get("brandName"));
        brand.setLogoURL(values.get("logoURL"));
        brand.setDescription(values.get("description"));
        brand.setProducts(product);
        return brand;
    }
}
