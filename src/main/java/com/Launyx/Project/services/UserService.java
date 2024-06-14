package com.Launyx.Project.services;

import com.Launyx.Project.entities.User;
import com.Launyx.Project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* Annotation que registra a classe como componente do Spring,
   tornando possível a injeção de dependência automática dela por meio do @AutoWired
*/
@Service
public class UserService {

    // Injeção de dependência
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long Id){
        Optional<User> obj = repository.findById(Id);
        // .get() retorna um objeto do tipo X do 'Optional<X>'
        return obj.get();
    }
}
