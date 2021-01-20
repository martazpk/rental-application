package com.mkopp.rentalapplication.infrastructure.persistency.jpa.hotelroomBookHistory;

import com.mkopp.rentalapplication.domain.hotelBookHistory.HotelBookingHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SpringHotelRoomHistoryRepository extends CrudRepository<HotelBookingHistory, String> {
}
