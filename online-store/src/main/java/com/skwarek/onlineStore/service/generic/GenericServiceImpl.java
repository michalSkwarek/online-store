package com.skwarek.onlineStore.service.generic;

import com.skwarek.onlineStore.data.dao.generic.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Michal on 26.09.2016.
 */
@Service
public abstract class GenericServiceImpl<E, K extends Serializable> implements GenericService<E, K> {

    @Autowired
    private GenericDao<E, K> genericDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public E getById(K id) {
        return genericDao.getById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(E entity) {
        genericDao.save(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(E entity) {
        genericDao.update(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void remove(E entity) {
        genericDao.remove(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<E> getAll() {
        return genericDao.getAll();
    }
}
