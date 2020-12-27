package com.mkopp.rentalapplication.infrastructure.persistency.jpa.hotel;

import com.mkopp.rentalapplication.domain.hotel.Hotel;
import com.mkopp.rentalapplication.domain.hotel.HotelRepository;

public class JpaHotelRepository implements HotelRepository {
    private final SpringJpaHotelRepository springJpaHotelRepository;

    public JpaHotelRepository(SpringJpaHotelRepository springJpaHotelRepository) {
        this.springJpaHotelRepository = springJpaHotelRepository;
    }

    @Override
    public void save(Hotel hotel) {
        springJpaHotelRepository.save(hotel);
    }
}
