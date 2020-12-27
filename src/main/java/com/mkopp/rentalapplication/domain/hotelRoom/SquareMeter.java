package com.mkopp.rentalapplication.domain.hotelRoom;

import javax.persistence.Embeddable;

@Embeddable
class SquareMeter {
    private Double squareMeter;

    SquareMeter(Double squareMeter) {
        this.squareMeter = squareMeter;
    }

    protected SquareMeter() {
    }
}
