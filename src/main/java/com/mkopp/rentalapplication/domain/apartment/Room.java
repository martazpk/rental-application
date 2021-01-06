package com.mkopp.rentalapplication.domain.apartment;

import javax.persistence.*;

@Entity
@Table(name = "APARTMENT_ROOM")
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
