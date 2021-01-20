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

    private Room() {
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private SquereMeter getSquareMeter() {
        return squareMeter;
    }

    private void setSquareMeter(SquereMeter squareMeter) {
        this.squareMeter = squareMeter;
    }
}
