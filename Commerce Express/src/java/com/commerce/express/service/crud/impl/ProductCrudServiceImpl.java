/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.Product;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.ProductCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("productCrudService")
@Transactional
public class ProductCrudServiceImpl implements ProductCrudService {
        @Autowired
    private GenericDAO<Product> dao;

    public final void setDao(final GenericDAO< Product> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Product.class);
    }
}
