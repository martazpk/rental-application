package com.mkopp.rentalapplication.domain.hotelRoom;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Section {
    @Id
    @GeneratedValue
    private String id;
    private String name;
    @Embedded
    private SquareMeter squareMeter;

    Section(String name, SquareMeter squareMeter) {
        this.name = name;
        this.squareMeter = squareMeter;
    }

    protected Section() {
    }
}
