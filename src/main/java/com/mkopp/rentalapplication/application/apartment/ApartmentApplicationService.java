package com.mkopp.rentalapplication.application.apartment;

import com.mkopp.rentalapplication.domain.apartment.Address;
import com.mkopp.rentalapplication.domain.apartment.Appartment;
import com.mkopp.rentalapplication.domain.apartment.Room;
import com.mkopp.rentalapplication.domain.apartment.SquereMeter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApartmentApplicationService {

    public void add(
            String ownerId, String street, String postalCode, String houseNumber, String apartmentNumber,
            String city, String country, String description, Map<String, Double> roomsDefinition) {

        Address address = new Address(street, postalCode, houseNumber, apartmentNumber, city, country);
        List<Room> rooms = new ArrayList<>();
        roomsDefinition.forEach((name, size) -> {
            rooms.add(new Room(name, new SquereMeter(size)));
        });
        Appartment apartment = new Appartment(ownerId, address, rooms);
    }
}
