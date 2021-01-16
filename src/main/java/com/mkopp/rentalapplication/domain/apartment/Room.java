package com.mkopp.rentalapplication.domain.apartment;

import javax.persistence.*;

@Embeddable
class Room {
    private String name;
    @Embedded
    private SquereMeter squareMeter;

    Room(String name, SquereMeter squereMeter) {
        this.name = name;
        this.squareMeter = squereMeter;
    }

    protected Room() {
    }
}
