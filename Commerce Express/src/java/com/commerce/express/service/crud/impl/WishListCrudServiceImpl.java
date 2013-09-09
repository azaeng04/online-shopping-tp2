/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.WishList;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.WishListCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("wishListCrudService")
@Transactional
public class WishListCrudServiceImpl implements WishListCrudService {

    @Autowired
    private GenericDAO<WishList> dao;

    public final void setDao(final GenericDAO< WishList> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(WishList.class);
    }
}
