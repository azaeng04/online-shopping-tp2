/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.factory;

import com.commerce.express.domain.Brand;
import com.commerce.express.domain.Product;
import java.util.List;

/**
 *
 * @author cna canal walk
 */
public class BrandFactory {

    public static class Builder {

        private String brandID;
        private String brandName;
        private String logoURL;
        private String description;
        private List<Product> products;        

        public Builder(String brandID) {
            this.brandID += brandID;
        }

        public Builder setBrandName(String brandName) {
            this.brandName = brandName;
            return this;
        }

        public Builder setLogoURL(String logoURL) {
            this.logoURL = logoURL;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setProducts(List<Product> products) {
            this.products = products;
            return this;
        }
        
        public Brand buildBrand() {
            return buildBrand(this);
        }

        private Brand buildBrand(Builder object) {
            Brand brand = new Brand();
            brand.setBrandID(object.brandID);
            brand.setBrandName(object.brandName);
            brand.setLogoURL(object.logoURL);
            brand.setDescription(object.description);
            brand.setProducts(object.products);
            return brand;
        }
    }
}
