package com.mkopp.rentalapplication.domain.hotel;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
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
