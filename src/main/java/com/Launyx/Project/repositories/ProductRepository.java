package com.Launyx.Project.repositories;

import com.Launyx.Project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    Esta classe não precisa de uma annotation para registrá-la como componente do Spring
    Uma vez que ela herda da classe JpaRepository que já está registrada como componento do Spring
 */
public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
