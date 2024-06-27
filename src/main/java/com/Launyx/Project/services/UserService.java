package com.Launyx.Project.services;

import com.Launyx.Project.entities.User;
import com.Launyx.Project.repositories.UserRepository;
import com.Launyx.Project.services.exceptions.DatabaseException;
import com.Launyx.Project.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(Id));
    }

    // Método para adicionar um usuário
    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
            } else {
                throw new ResourceNotFoundException(id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj){

        User entity = repository.getReferenceById(id);
        try{
            updateData(entity, obj);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
