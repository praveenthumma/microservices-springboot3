package com.tp.ms.orderservice.repository;

import com.tp.ms.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface  OrderRepository extends JpaRepository<Order, Long>{

}
