package com.mkopp.rentalapplication.infrastructure.persistency.jpa.hotelroom;

import com.mkopp.rentalapplication.domain.hotelRoom.HotelRoom;
import org.springframework.data.repository.CrudRepository;

interface SpringJpaHotelRoomRepository extends CrudRepository<HotelRoom, String> {
}
