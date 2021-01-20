package com.mkopp.rentalapplication.domain.hotelRoom;

import javax.persistence.Embeddable;

@Embeddable
class SquareMeter {
    private Double squareMeter;

    SquareMeter(Double squareMeter) {
        this.squareMeter = squareMeter;
    }

    private SquareMeter() {
    }

    private Double getSquareMeter() {
        return squareMeter;
    }

    private void setSquareMeter(Double squareMeter) {
        this.squareMeter = squareMeter;
    }
}
