package com.Launyx.Project.Resources;

import com.Launyx.Project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Launyx.Project.entities.User;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


// Annotation para designar que esta classe é um recurso web, implementado por um controlador Rest
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    // Injeção de dependência
    @Autowired
    private UserService service;

    // Annotation para indicar que este método responde a requisição do tipo get do HTTP
    @GetMapping   
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        // .ok() retorna respota com sucesso
        return ResponseEntity.ok().body(list);
    }

    /*

     */
    @GetMapping(value = "/{id}")
    /*
        Annotation para o Spring aceitar o Id e considerá-lo como parâmetro da URL
     */
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
