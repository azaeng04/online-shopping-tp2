/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.factory;

import com.commerce.express.domain.Product;
import com.commerce.express.domain.ProductStatus;
import com.commerce.express.domain.Rating;

/**
 *
 * @author cna canal walk
 */
public class ProductFactory {

    private ProductFactory() {
    }

    public static class Builder {

        private String productID = "PRD_";
        private String productName;
        private String description;
        private String productPrice;
        private String imageURL;
        private Rating rating;
        private ProductStatus productStatus;

        public Builder(String productID) {
            this.productID += productID;
        }

        public Builder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder setRating(Rating rating) {
            this.rating = rating;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setProductPrice(String productPrice) {
            this.productPrice = productPrice;
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
            product.setProductPrice(object.productPrice);
            product.setDescription(object.description);
            product.setRating(object.rating);
            product.setImageURL(object.imageURL);
            product.setProductStatus(object.productStatus);
            return product;
        }
    }
}
