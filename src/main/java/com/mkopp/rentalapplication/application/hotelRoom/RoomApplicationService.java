package com.mkopp.rentalapplication.application.hotelRoom;

import com.mkopp.rentalapplication.domain.eventchannel.EventChannel;
import com.mkopp.rentalapplication.domain.hotelRoom.HotelRoom;
import com.mkopp.rentalapplication.domain.hotelRoom.HotelRoomFactory;
import com.mkopp.rentalapplication.domain.hotelRoom.HotelRoomRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class RoomApplicationService {
    private final HotelRoomRepository hotelRoomRepository;
    private final EventChannel eventChannel;

    public RoomApplicationService(HotelRoomRepository hotelRoomRepository, EventChannel eventChannel) {
        this.hotelRoomRepository = hotelRoomRepository;
        this.eventChannel = eventChannel;
    }

    public void add(String hotelId, int number, String description, Map<String, Double> sectionsDefinition) {
        HotelRoom hotelRoom = new HotelRoomFactory().create(hotelId, number, description, sectionsDefinition);

        hotelRoomRepository.save(hotelRoom);
    }

    public void book(String id, String tenantId, List<LocalDate> dates) {
        HotelRoom hotelRoom = hotelRoomRepository.getById(id);

        hotelRoom.book(tenantId, dates, eventChannel);
    }
}
