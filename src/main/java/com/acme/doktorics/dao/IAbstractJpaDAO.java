package com.acme.doktorics.dao;

import java.util.List;

import com.acme.doktorics.domain.Sorting;

public interface IAbstractJpaDAO<T> {

	void setClazz(final Class<T> clazzToSet);

	T findOne(final Long id);

	List<T> findAll();
	
	void save(final T entity);

	void update(final T entity);

	void delete(final T entity);

	T findByCustomField(String key, String value);
	 
	List<T> findAllBySorting(String field, Sorting sorting) ;
	
}