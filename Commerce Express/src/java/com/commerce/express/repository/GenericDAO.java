package com.commerce.express.repository;

import java.io.Serializable;

/**
 *
 * @author boniface
 * @param <T>
 */
public interface GenericDAO < T extends Serializable > extends DAO< T, Long>{
	void setClazz( final Class< T > clazzToSet );
}

