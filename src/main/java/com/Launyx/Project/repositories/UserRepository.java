package com.Launyx.Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Launyx.Project.entities.User;

/*
    Esta classe não precisa de uma annotation para registrá-la como componente do Spring
    Uma vez que ela herda da classe JpaRepository que já está registrada como componento do Spring
 */
public interface UserRepository extends JpaRepository<User, Long>{
    
}
