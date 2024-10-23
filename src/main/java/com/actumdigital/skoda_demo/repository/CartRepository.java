package com.actumdigital.skoda_demo.repository;

import com.actumdigital.skoda_demo.model.Cart;
import com.actumdigital.skoda_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByUser(User user);

}
