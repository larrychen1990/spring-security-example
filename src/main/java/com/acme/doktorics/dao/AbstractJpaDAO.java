package com.acme.doktorics.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.acme.doktorics.domain.Sorting;

public class AbstractJpaDAO<T> implements IAbstractJpaDAO<T> {
    private Class<T> clazz;

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void setClazz(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public T findOne(final Long id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public List<T> findAll() {
        List<T> result = entityManager.createQuery("from " + clazz.getName())
                .getResultList();
        return result;

    }

    @SuppressWarnings("unchecked")
    @Override
    public T findByCustomField(String key, String value) {
        String queryString = "SELECT u FROM " + clazz.getSimpleName() + " u WHERE u." + key + " = '" + value + "'";
        Query query = entityManager.createQuery(queryString);
        return (T) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAllBySorting(String field, Sorting sorting) {
        String queryString = "SELECT u FROM " + clazz.getSimpleName() + " ORDER BY " + field + " " + sorting.getSorter();
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();
    }

    @Override
    public void save(final T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(final T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(final T entity) {
        entityManager.remove(entity);
    }

    @Override
    public T findElementByName(String field, String name) {
        String queryString = "SELECT u FROM " + clazz.getSimpleName() + " u WHERE u."+field+"='"+name+"'";
        Query query = entityManager.createQuery(queryString);
        return (T) query.getSingleResult();
    }

}
