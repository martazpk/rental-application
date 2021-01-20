package com.mkopp.rentalapplication.infrastructure.persistency.jpa.hotelroomBookHistory;

import com.mkopp.rentalapplication.domain.hotelBookHistory.HotelBookingHistory;
import com.mkopp.rentalapplication.domain.hotelBookHistory.HotelBookingHistoryRepository;

import java.util.Optional;

public class JpaHotelBookingHistoryRepository implements HotelBookingHistoryRepository {
    private final SpringHotelRoomHistoryRepository springRepository;

    public JpaHotelBookingHistoryRepository(SpringHotelRoomHistoryRepository springRepository) {
        this.springRepository = springRepository;
    }

    @Override
    public Optional<HotelBookingHistory> getFor(String roomId) {
        return springRepository.findById(roomId);
    }

    @Override
    public void save(HotelBookingHistory history) {
        springRepository.save(history);
    }
}
