package com.mkopp.rentalapplication.query.hotelRoom;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class HotelRoomQueryRepository {
    private final SpringRoomReadModelRepository springRepository;

    public HotelRoomQueryRepository(SpringRoomReadModelRepository springRepository) {
        this.springRepository = springRepository;
    }

    public List<HotelRoomReadModel> findByHotelId(String hotelId) {
        return springRepository.findByHotelId(hotelId);
    }
}
