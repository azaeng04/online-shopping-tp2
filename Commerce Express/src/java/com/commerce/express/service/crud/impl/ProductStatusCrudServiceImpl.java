/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.ProductStatus;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.ProductStatusCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("productStatusCrudService")
@Transactional
public class ProductStatusCrudServiceImpl implements ProductStatusCrudService {

    @Autowired
    private GenericDAO<ProductStatus> dao;

    public final void setDao(final GenericDAO< ProductStatus> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(ProductStatus.class);
    }
}
