package com.Launyx.Project.repositories;

import com.Launyx.Project.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    Esta classe não precisa de uma annotation para registrá-la como componente do Spring
    Uma vez que ela herda da classe JpaRepository que já está registrada como componento do Spring
 */
public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
