package com.thoughtworks;

import java.util.List;

public interface Repository<E> {
    public void save(String id, E entity);

    public E get(String id);

    public void delete(String id);

    public void update(String id, E entity);

    public List<E> list();
}
