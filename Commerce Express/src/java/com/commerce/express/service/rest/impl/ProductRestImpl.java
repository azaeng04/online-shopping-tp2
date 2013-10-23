/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.rest.impl;

import com.commerce.express.domain.Product;
import com.commerce.express.service.crud.ProductCrudService;
import com.commerce.express.service.rest.ProductRestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("productService")
@Transactional
public class ProductRestImpl implements ProductRestService {

    @Autowired
    private ProductCrudService productCrudService;

    @Override
    public List<Product> getProducts() {
        return productCrudService.findAll();
    }
}
