package com.Launyx.Project.Resources;

import com.Launyx.Project.entities.User;
import com.Launyx.Project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    // Annotation para o Spring aceitar o Id e considerá-lo como parâmetro da URL
    @GetMapping(value = "/{id}")

    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    /*
        Annotation do spring para pre-processar na compilação do controlador (classe que possui @RestController)
        definindo que o método vai receber o método post do HTTP
     */
    @PostMapping
    // Annotation para dizer que o objeto vai chegar no Json e o Json vai ser desserializado para um objeto User
    public ResponseEntity<User> insert(@RequestBody User obj){
        // Forma correta de inserir um objeto no banco de dados
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
