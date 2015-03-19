/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.repository;

import java.util.List;

/**
 *
 * @author boniface
 */
public interface DAO<T, D> {

    public T findById(final D id);

    public List<T> findAll();

    public void persist(final T entity);

    public void persistMultipleEntites(final List<T> entities);

    public void merge(final T entity);

    public void remove(final T entity);

    public void removeMultipleEntities(final List<T> entities);

    public void removeById(final Long entityId);

    public List<T> findInRange(int firstResult, int maxResults);

    public long count();

    public T getByPropertyName(String name, String value);

    public List<T> getEntitiesByPropertyName(String name, String value);
}
