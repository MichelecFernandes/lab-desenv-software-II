package br.fai.backend.lds.backend.main.port.dao.crud;

public interface CreateDao<T> {
    int add(final T entity);

}
