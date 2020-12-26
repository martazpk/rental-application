package com.mkopp.rentalapplication.domain.hotelRoom;

class Section {
    private final String name;
    private final SquareMeter squareMeter;

    Section(String name, SquareMeter squareMeter) {
        this.name = name;
        this.squareMeter = squareMeter;
    }
}
