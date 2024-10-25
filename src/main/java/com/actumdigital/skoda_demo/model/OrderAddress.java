package com.actumdigital.skoda_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_addresses")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class OrderAddress extends Address {

    @OneToOne(mappedBy = "billingAddress")
    private Order order;

}
