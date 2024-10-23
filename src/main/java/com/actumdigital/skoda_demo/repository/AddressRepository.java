package com.actumdigital.skoda_demo.repository;

import com.actumdigital.skoda_demo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {

}
