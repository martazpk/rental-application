package com.mkopp.rentalapplication.application.hotel;

import com.mkopp.rentalapplication.domain.hotel.Hotel;
import com.mkopp.rentalapplication.domain.hotel.HotelFactory;
import com.mkopp.rentalapplication.domain.hotel.HotelRepository;
import org.springframework.stereotype.Service;

@Service
public class HotelApplicationService {
    private final HotelRepository hotelRepository;

    public HotelApplicationService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public void add(String name, String street, String buildingNumber, String postalCode, String city, String country){
       Hotel hotel = new HotelFactory().create(name, street, buildingNumber, postalCode, city, country);

       hotelRepository.save(hotel);
    }
}
