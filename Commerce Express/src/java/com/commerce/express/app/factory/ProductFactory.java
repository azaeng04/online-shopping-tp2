/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.factory;

import com.commerce.express.domain.Brand;
import com.commerce.express.domain.Product;
import com.commerce.express.domain.ProductStatus;
import java.util.List;

/**
 *
 * @author cna canal walk
 */
public class ProductFactory {

    public static class Builder {

        private String productID;
        private String productName;
        private String description;
        private String imageURL;
        private ProductStatus productStatus;

        public Builder(String productID) {
            this.productID += productID;
        }

        public Builder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setImageURL(String imageURL) {
            this.imageURL = imageURL;
            return this;
        }

        public Builder setProductStatus(ProductStatus productStatus) {
            this.productStatus = productStatus;
            return this;
        }
        
        public Product buildProduct() {
            return buildProduct(this);
        }
        
        private Product buildProduct(Builder object) {
            Product product = new Product();
            product.setProductID(object.productID);
            product.setProductName(object.productName);
            product.setDescription(object.description);
            product.setImageURL(object.imageURL);
            product.setProductStatus(object.productStatus);
            return product;
        }
    }
}
