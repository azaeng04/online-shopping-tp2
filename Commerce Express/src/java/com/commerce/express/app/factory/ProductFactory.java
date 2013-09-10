/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.factory;

import com.commerce.express.domain.Product;
import com.commerce.express.domain.ProductStatus;
import java.util.Map;

/**
 *
 * @author cna canal walk
 */
public class ProductFactory {

    public static Product getProduct(Map<String, String> values, ProductStatus productStatus) {
        Product product = new Product();
        product.setProductName(values.get("productName"));
        product.setDescription(values.get("description"));
        product.setImageURL(values.get("imageURL"));
        product.setProductStatus(productStatus);
        return product;
    }
}
