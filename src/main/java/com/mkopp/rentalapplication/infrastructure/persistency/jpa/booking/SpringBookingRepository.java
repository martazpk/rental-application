package com.mkopp.rentalapplication.infrastructure.persistency.jpa.booking;

import com.mkopp.rentalapplication.domain.apartment.Booking;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SpringBookingRepository extends CrudRepository<Booking, UUID> {
}
