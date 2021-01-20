package com.mkopp.rentalapplication.query.apartment;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SpringQueryBookingRepository extends CrudRepository<ApartmentBookingHistoryReadModel, UUID> {
}
