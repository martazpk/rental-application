package com.mkopp.rentalapplication.domain.apartment;

public class Room {
    private final String name;
    private final SquereMeter squereMeter;

    public Room(String name, SquereMeter squereMeter) {

        this.name = name;
        this.squereMeter = squereMeter;
    }
}
