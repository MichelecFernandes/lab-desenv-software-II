package br.fai.backend.lds.backend.main.port.service.crud;


public interface CreateService<T> {
   int create(final T entity);

}
