package com.mkopp.rentalapplication.infrastructure.persistency.jpa.hotelroom;

import com.mkopp.rentalapplication.domain.hotelRoom.HotelRoom;
import com.mkopp.rentalapplication.domain.hotelRoom.HotelRoomRepository;

public class JpaHotelRoomRepository implements HotelRoomRepository {
    private final SpringJpaHotelRoomRepository springJpaHotelRoomRepository;

    public JpaHotelRoomRepository(SpringJpaHotelRoomRepository springJpaHotelRoomRepository) {
        this.springJpaHotelRoomRepository = springJpaHotelRoomRepository;
    }

    @Override
    public void save(HotelRoom hotelRoom) {
        springJpaHotelRoomRepository.save(hotelRoom);
    }
}
