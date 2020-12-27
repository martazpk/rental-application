package com.mkopp.rentalapplication.infrastructure.persistency.jpa.hotel;

import com.mkopp.rentalapplication.domain.hotel.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface SpringJpaHotelRepository extends CrudRepository<Hotel, String> {
}
