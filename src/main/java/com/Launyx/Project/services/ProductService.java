package com.Launyx.Project.services;

import com.Launyx.Project.entities.Product;
import com.Launyx.Project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* Annotation que registra a classe como componente do Spring,
   tornando possível a injeção de dependência automática dela por meio do @AutoWired
*/
@Service
public class ProductService {

    // Injeção de dependência
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long Id){
        Optional<Product> obj = repository.findById(Id);
        // .get() retorna um objeto do tipo X do 'Optional<X>'
        return obj.get();
    }
}
