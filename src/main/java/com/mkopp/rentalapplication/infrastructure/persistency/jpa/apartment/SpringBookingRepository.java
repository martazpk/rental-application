package com.mkopp.rentalapplication.infrastructure.persistency.jpa.apartment;

import com.mkopp.rentalapplication.domain.apartment.Booking;
import org.springframework.data.repository.CrudRepository;

interface SpringBookingRepository extends CrudRepository<Booking, String> {
}
