package br.fai.backend.lds.backend.main.service.product;

import br.fai.backend.lds.backend.main.domain.Product;
import br.fai.backend.lds.backend.main.port.service.crud.CreateService;
import br.fai.backend.lds.backend.main.port.service.crud.DeleteService;

public class ProductServiceImpl implements CreateService<Product>, DeleteService {
    @Override
    public int create(Product entity) {
        return 0;
    }

    @Override
    public void delete(int id) {

    }
}
