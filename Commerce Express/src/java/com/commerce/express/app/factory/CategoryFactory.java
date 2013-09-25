/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.factory;

import com.commerce.express.domain.Category;
import com.commerce.express.domain.Product;
import java.util.List;

/**
 *
 * @author cna canal walk
 */
public class CategoryFactory {

    public static Category getCategory(String categoryID, String categoryName, List<Product> product) {
        Category category = new Category();
        category.setCategoryID(categoryID);
        category.setCategoryName(categoryName);
        category.setProducts(product);
        return category;
    }
}
