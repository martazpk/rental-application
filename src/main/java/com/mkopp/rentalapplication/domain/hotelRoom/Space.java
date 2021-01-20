package com.mkopp.rentalapplication.domain.hotelRoom;

import javax.persistence.*;

@Embeddable
class Space {
    private String name;
    @Embedded
    private SquareMeter squareMeter;

    Space(String name, SquareMeter squareMeter) {
        this.name = name;
        this.squareMeter = squareMeter;
    }

    private Space() {
    }
}
