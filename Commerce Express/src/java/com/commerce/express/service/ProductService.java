package com.commerce.express.service;

import com.commerce.express.domain.Product;
import java.util.List;

/**
 *
 * @author Owner
 */
public interface ProductService {

    public List<Product> getProducts(Long categoryID);

    public void updateInStock(String order);

    public List<Product> getProducts();
}
