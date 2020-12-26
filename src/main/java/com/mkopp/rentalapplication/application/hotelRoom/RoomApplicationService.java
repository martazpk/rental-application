package com.mkopp.rentalapplication.application.hotelRoom;

import com.mkopp.rentalapplication.domain.hotelRoom.HotelRoom;
import com.mkopp.rentalapplication.domain.hotelRoom.HotelRoomFactory;

import java.util.Map;

public class RoomApplicationService {
    void add(String hotelId, int number, String description, Map<String, Double> sectionsDefinition){
        HotelRoom hotelRoom =new HotelRoomFactory().create(hotelId, number, description, sectionsDefinition);
    }
}
