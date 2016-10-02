package com.skwarek.onlineStore.data.dao.generic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Michal on 26.09.2016.
 */
@Repository
public abstract class GenericDaoImpl<E, K extends Serializable> implements GenericDao<E, K> {

    private Class<? extends E> daoType;

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public GenericDaoImpl() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        daoType = (Class<E>) parameterizedType.getActualTypeArguments()[0];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public E getById(K id) {
        return getSession().get(daoType, id);
    }

    @Override
    public void save(E entity) {
        getSession().save(entity);
    }

    @Override
    public void update(E entity) {
        getSession().update(entity);
    }

    @Override
    public void remove(E entity) {
        getSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<E> getAll() {
        return getSession().createCriteria(daoType).list();
    }
}

