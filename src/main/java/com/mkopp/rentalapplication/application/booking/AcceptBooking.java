package com.mkopp.rentalapplication.application.booking;

import lombok.Getter;

@Getter
public class AcceptBooking {
    private final String id;

    public AcceptBooking(String id) {
        this.id = id;
    }
}
