/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.Brand;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.BrandCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("brandCrudService")
@Transactional
public class BrandCrudServiceImpl implements BrandCrudService {

    @Autowired
    private GenericDAO<Brand> dao;

    public final void setDao(final GenericDAO< Brand> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Brand.class);
    }

    public BrandCrudServiceImpl() {
    }
}
