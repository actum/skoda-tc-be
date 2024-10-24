package com.actumdigital.skoda_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "order_addresses")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class OrderAddress extends Address {

    @OneToOne(mappedBy = "billingAddress")
    private Order order;

}
