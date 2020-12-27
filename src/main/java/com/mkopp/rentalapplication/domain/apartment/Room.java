package com.mkopp.rentalapplication.domain.apartment;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Room {
    @Id
    @GeneratedValue
    private String id;
    private String name;
    @Embedded
    private SquereMeter squereMeter;

    Room(String name, SquereMeter squereMeter) {
        this.name = name;
        this.squereMeter = squereMeter;
    }

    protected Room() {
    }
}
