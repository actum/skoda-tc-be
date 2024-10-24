package com.actumdigital.skoda_demo.repository;

import com.actumdigital.skoda_demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
