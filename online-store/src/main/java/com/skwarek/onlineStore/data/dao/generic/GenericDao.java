package com.skwarek.onlineStore.data.dao.generic;

import java.util.List;

/**
 * Created by Michal on 26.09.2016.
 */
public interface GenericDao<E, K> {

    E getById(K id);

    void save(E entity);

    void update(E entity);

    void remove(E entity);

    List<E> getAll();
}