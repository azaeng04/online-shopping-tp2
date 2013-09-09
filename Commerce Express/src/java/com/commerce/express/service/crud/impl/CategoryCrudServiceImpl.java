/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.Category;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.CategoryCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("categoryCrudService")
@Transactional
public class CategoryCrudServiceImpl implements CategoryCrudService {

    @Autowired
    private GenericDAO<Category> dao;

    public final void setDao(final GenericDAO< Category> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Category.class);
    }

    public CategoryCrudServiceImpl() {
    }
}
