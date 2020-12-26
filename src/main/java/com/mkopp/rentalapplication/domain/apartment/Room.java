package com.mkopp.rentalapplication.domain.apartment;

class Room {
    private final String name;
    private final SquereMeter squereMeter;

    Room(String name, SquereMeter squereMeter) {
        this.name = name;
        this.squereMeter = squereMeter;
    }
}
