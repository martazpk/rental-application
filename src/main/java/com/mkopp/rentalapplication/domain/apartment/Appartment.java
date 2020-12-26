package com.mkopp.rentalapplication.domain.apartment;

import java.util.List;

public class Appartment {
    private final String ownerId;
    private final Address address;
    private final List<Room> rooms;

    public Appartment(String ownerId, Address address, List<Room> rooms) {

        this.ownerId = ownerId;
        this.address = address;
        this.rooms = rooms;
    }
}
