package com.mkopp.rentalapplication.infrastructure.persistency.jpa.hotelroom;

import com.mkopp.rentalapplication.domain.hotelRoom.HotelRoom;
import com.mkopp.rentalapplication.domain.hotelRoom.HotelRoomRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class JpaHotelRoomRepository implements HotelRoomRepository {
    private final SpringJpaHotelRoomRepository springJpaHotelRoomRepository;

    public JpaHotelRoomRepository(SpringJpaHotelRoomRepository springJpaHotelRoomRepository) {
        this.springJpaHotelRoomRepository = springJpaHotelRoomRepository;
    }

    @Override
    public String save(HotelRoom hotelRoom) {
       return springJpaHotelRoomRepository.save(hotelRoom).id();

    }

    @Override
    public HotelRoom getById(String id) {
        return springJpaHotelRoomRepository.findById(UUID.fromString(id)).orElseThrow(() -> new HotelRoomDoesNotExistException(id));
    }
}
