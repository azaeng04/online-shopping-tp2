/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.crud.impl;

import com.commerce.express.domain.Rating;
import com.commerce.express.repository.GenericDAO;
import com.commerce.express.service.crud.RatingCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cna canal walk
 */
@Service("ratingCrudService")
@Transactional
public class RatingCrudServiceImpl implements RatingCrudService {

    @Autowired
    private GenericDAO<Rating> dao;

    public final void setDao(final GenericDAO< Rating> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Rating.class);
    }
}
