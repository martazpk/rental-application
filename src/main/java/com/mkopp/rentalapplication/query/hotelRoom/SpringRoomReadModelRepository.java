package com.mkopp.rentalapplication.query.hotelRoom;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpringRoomReadModelRepository extends CrudRepository<HotelRoomReadModel, String> {
    List<HotelRoomReadModel> findByHotelId(String hotelId);
}
