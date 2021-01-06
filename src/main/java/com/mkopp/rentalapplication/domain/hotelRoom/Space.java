package com.mkopp.rentalapplication.domain.hotelRoom;

import javax.persistence.*;

@Entity
@Table(name = "ROOM_SPACE")
class Space {
    @Id
    @GeneratedValue
    private String id;
    private String name;
    @Embedded
    private SquareMeter squareMeter;

    Space(String name, SquareMeter squareMeter) {
        this.name = name;
        this.squareMeter = squareMeter;
    }

    protected Space() {
    }
}
