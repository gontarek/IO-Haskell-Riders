package io.riders.services;

import java.util.List;

/**
 * Created by tommy on 5/5/2017.
 */
public interface CRUDService<T> {

    List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);
}
