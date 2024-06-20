package com.Launyx.Project.Resources;

import com.Launyx.Project.entities.Category;
import com.Launyx.Project.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// Annotation para designar que esta classe é um recurso web, implementado por um controlador Rest
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    // Injeção de dependência
    @Autowired
    private CategoryService service;

    // Annotation para indicar que este método responde a requisição do tipo get do HTTP
    @GetMapping   
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = service.findAll();
        // .ok() retorna respota com sucesso
        return ResponseEntity.ok().body(list);
    }

    /*

     */
    @GetMapping(value = "/{id}")
    /*
        Annotation para o Spring aceitar o Id e considerá-lo como parâmetro da URL
     */
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
