package com.mkopp.rentalapplication.domain.hotelRoom;

public interface HotelRoomRepository {
    String save(HotelRoom hotelRoom);

    HotelRoom getById(String id);
}
