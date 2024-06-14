package com.Launyx.Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Launyx.Project.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
