package com.mkopp.rentalapplication.application.hotelRoom;

import com.mkopp.rentalapplication.domain.hotelRoom.HotelRoom;
import com.mkopp.rentalapplication.domain.hotelRoom.HotelRoomFactory;
import com.mkopp.rentalapplication.domain.hotelRoom.HotelRoomRepository;

import java.util.Map;

public class RoomApplicationService {
    private final HotelRoomRepository hotelRoomRepository;

    public RoomApplicationService(HotelRoomRepository hotelRoomRepository) {
        this.hotelRoomRepository = hotelRoomRepository;
    }

    void add(String hotelId, int number, String description, Map<String, Double> sectionsDefinition){
        HotelRoom hotelRoom =new HotelRoomFactory().create(hotelId, number, description, sectionsDefinition);

        hotelRoomRepository.save(hotelRoom);
    }
}
