package com.Launyx.Project.Resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Launyx.Project.entities.User;
import org.springframework.web.bind.annotation.GetMapping;


// Annotation para designar que esta classe é um recurso web, implementado por um controlador Rest
@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    // Annotation para indicar que este método responde a requisição do tipo get do HTTP
    @GetMapping   
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Maria", "maria@gmail.com", "999999999", "12345");
        // .ok() retorna respota com sucesso
        return ResponseEntity.ok().body(u);
    }
}
