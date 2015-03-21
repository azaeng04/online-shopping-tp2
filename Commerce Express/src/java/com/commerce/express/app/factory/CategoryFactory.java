package com.commerce.express.app.factory;

import com.commerce.express.domain.Category;
import com.commerce.express.domain.Product;
import java.util.List;

/**
 *
 * @author cna canal walk
 */
public class CategoryFactory {

    private CategoryFactory() {
    }

    public static Category getCategory(String categoryID, String categoryName, List<Product> product) {
        Category category = new Category();
        category.setCategoryID("CAT_" + categoryID);
        category.setCategoryName(categoryName);
        category.setProducts(product);
        return category;
    }
}
