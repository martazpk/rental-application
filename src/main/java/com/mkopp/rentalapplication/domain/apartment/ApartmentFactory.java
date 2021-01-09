package com.mkopp.rentalapplication.domain.apartment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApartmentFactory {
    public Apartment create(String ownerId, String street, String postalCode, String houseNumber, String apartmentNumber,
                            String city, String country, Map<String, Double> roomsDefinition, String description) {
        Address address = new Address(street, postalCode, houseNumber, apartmentNumber, city, country);
        List<Room> rooms = new ArrayList<>();
        roomsDefinition.forEach((name, size) -> {
            rooms.add(new Room(name, new SquereMeter(size)));
        });
        return new Apartment(ownerId, address, rooms, description);
    }
}
