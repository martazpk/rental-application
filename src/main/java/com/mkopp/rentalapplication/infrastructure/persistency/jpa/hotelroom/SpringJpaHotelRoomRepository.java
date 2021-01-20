package com.mkopp.rentalapplication.infrastructure.persistency.jpa.hotelroom;

import com.mkopp.rentalapplication.domain.hotelRoom.HotelRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
interface SpringJpaHotelRoomRepository extends CrudRepository<HotelRoom, UUID> {
}
