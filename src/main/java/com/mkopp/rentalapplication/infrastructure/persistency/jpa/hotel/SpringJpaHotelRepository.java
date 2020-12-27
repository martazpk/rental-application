package com.mkopp.rentalapplication.infrastructure.persistency.jpa.hotel;

import com.mkopp.rentalapplication.domain.hotel.Hotel;
import org.springframework.data.repository.CrudRepository;

interface SpringJpaHotelRepository extends CrudRepository<Hotel, String> {
}
