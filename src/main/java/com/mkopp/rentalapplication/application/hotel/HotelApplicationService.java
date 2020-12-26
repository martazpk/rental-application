package com.mkopp.rentalapplication.application.hotel;

import com.mkopp.rentalapplication.domain.hotel.Hotel;
import com.mkopp.rentalapplication.domain.hotel.HotelFactory;

public class HotelApplicationService {
    void add(String name, String street, String buildingNumber, String postalCode, String city, String country){
       Hotel hotel = new HotelFactory().create(name, street, buildingNumber, postalCode, city, country);
    }
}
