package com.mkopp.rentalapplication.domain.hotel;

import javax.persistence.*;

@Entity
@Table(name = "HOTELS")
public class Hotel {
    @Id
    @GeneratedValue
    private String id;
    private String name;
    @Embedded
    private Address address;

    Hotel(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    protected Hotel() {
    }
}
