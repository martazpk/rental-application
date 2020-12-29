package com.mkopp.rentalapplication.domain.hotelRoom;

public interface HotelRoomRepository {
    void save(HotelRoom hotelRoom);

    HotelRoom getById(String id);
}
