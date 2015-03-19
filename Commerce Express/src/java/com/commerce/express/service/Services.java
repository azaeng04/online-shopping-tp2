/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service;

import java.util.List;

/**
 *
 * @author boniface
 */
public interface Services<T, D> {

    public T findById(final D id);

    public List<T> findAll();

    public void persist(final T entity);

    public void persistMultipleEntities(final List<T> entity);

    public void merge(final T entity);

    public void remove(final T entity);

    public void removeMultipleEntities(final List<T> entity);

    public void removeById(final Long entityId);

    public List<T> findInRange(int firstResult, int maxResults);

    public long count();

    public T getByPropertyName(String name, String value);

    public List<T> getEntitiesByPropertyName(String name, String value);
}
