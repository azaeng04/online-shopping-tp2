/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.FAQ;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.FAQCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("fAQCrudService")
@Transactional
public class FAQCrudServiceImpl implements FAQCrudService {

    @Autowired
    private GenericDAO<FAQ> dao;

    public final void setDao(final GenericDAO< FAQ> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(FAQ.class);
    }
}
