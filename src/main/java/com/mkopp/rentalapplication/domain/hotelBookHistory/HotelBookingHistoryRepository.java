package com.mkopp.rentalapplication.domain.hotelBookHistory;

import java.util.Optional;

public interface HotelBookingHistoryRepository {
     Optional<HotelBookingHistory> getFor(String roomId);

     void save(HotelBookingHistory history);
}
