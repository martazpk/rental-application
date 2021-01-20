package com.mkopp.rentalapplication.infrastructure.persistency.jpa.hotel;

import com.mkopp.rentalapplication.domain.hotel.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SpringJpaHotelRepository extends CrudRepository<Hotel, String> {
}
