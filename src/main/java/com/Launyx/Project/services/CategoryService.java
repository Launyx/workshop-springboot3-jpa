package com.Launyx.Project.services;

import com.Launyx.Project.entities.Category;
import com.Launyx.Project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* Annotation que registra a classe como componente do Spring,
   tornando possível a injeção de dependência automática dela por meio do @AutoWired
*/
@Service
public class CategoryService {

    // Injeção de dependência
    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long Id){
        Optional<Category> obj = repository.findById(Id);
        // .get() retorna um objeto do tipo X do 'Optional<X>'
        return obj.get();
    }
}
