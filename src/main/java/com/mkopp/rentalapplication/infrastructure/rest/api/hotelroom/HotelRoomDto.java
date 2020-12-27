package com.mkopp.rentalapplication.infrastructure.rest.api.hotelroom;

import java.util.Map;

public class HotelRoomDto {
    private final String hotelId;
    private final int number;
    private final String description;
    private final Map<String, Double> sectionsDefinition;

    public HotelRoomDto(String hotelId, int number, String description, Map<String, Double> sectionsDefinition) {
        this.hotelId = hotelId;
        this.number = number;
        this.description = description;
        this.sectionsDefinition = sectionsDefinition;
    }

    public String getHotelId() {
        return hotelId;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Double> getSectionsDefinition() {
        return sectionsDefinition;
    }
}
