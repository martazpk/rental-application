package com.mkopp.rentalapplication.query.apartment;

import org.springframework.data.repository.CrudRepository;

public interface SpringQueryBookingRepository extends CrudRepository<ApartmentBookingHistoryReadModel, String> {
}
