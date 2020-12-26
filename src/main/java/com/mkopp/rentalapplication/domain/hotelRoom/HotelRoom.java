package com.mkopp.rentalapplication.domain.hotelRoom;

import java.util.List;

public class HotelRoom {
    private final String hotelId;
    private final int number;
    private final String description;
    private final List<Section> sections;

    HotelRoom(String hotelId, int number, String description, List<Section> sections) {
        this.hotelId = hotelId;
        this.number = number;
        this.description = description;
        this.sections = sections;
    }
}
