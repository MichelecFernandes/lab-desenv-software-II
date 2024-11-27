package br.fai.backend.lds.backend.main.controller;

import br.fai.backend.lds.backend.main.domain.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    @GetMapping()
    public ResponseEntity<List<Product>> getEntitites(){
        List<Product> products =  List.of(
                new Product(1, "produto 1", 100),
                new Product(2, "produto 2", 200),
                new Product(3, "produto 3", 300),
                new Product(4, "produto 4", 400)

        );
        return ResponseEntity.ok(products);
    }

}
