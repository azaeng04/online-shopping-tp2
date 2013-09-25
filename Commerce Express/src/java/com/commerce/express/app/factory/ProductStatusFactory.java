/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.factory;

import com.commerce.express.domain.ProductStatus;

/**
 *
 * @author cna canal walk
 */
public class ProductStatusFactory {

    public static ProductStatus getProductStatus(String Status, int inStock) {
        ProductStatus productStatus = new ProductStatus();
        productStatus.setStatus(Status);
        productStatus.setInStock(inStock);
        return productStatus;
    }
}
