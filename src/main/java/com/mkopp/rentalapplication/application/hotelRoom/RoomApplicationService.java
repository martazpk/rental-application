package com.mkopp.rentalapplication.application.hotelRoom;

import com.mkopp.rentalapplication.domain.apartment.Booking;
import com.mkopp.rentalapplication.domain.apartment.BookingRepository;
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
    private final BookingRepository bookingRepository;

    public RoomApplicationService(HotelRoomRepository hotelRoomRepository, EventChannel eventChannel, BookingRepository bookingRepository) {
        this.hotelRoomRepository = hotelRoomRepository;
        this.eventChannel = eventChannel;
        this.bookingRepository = bookingRepository;
    }

    public void add(String hotelId, int number, String description, Map<String, Double> sectionsDefinition) {
        HotelRoom hotelRoom = new HotelRoomFactory().create(hotelId, number, description, sectionsDefinition);

        hotelRoomRepository.save(hotelRoom);
    }

    public void book(String id, String tenantId, List<LocalDate> dates) {
        HotelRoom hotelRoom = hotelRoomRepository.getById(id);

        Booking booking = hotelRoom.book(tenantId, dates, eventChannel);
        bookingRepository.save(booking);
    }
}
