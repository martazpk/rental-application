package com.mkopp.rentalapplication.infrastructure.persistency.jpa.apartmentBookHistory;

import com.mkopp.rentalapplication.domain.apartmentBookHistory.ApartmentBookingHistory;
import org.springframework.data.repository.CrudRepository;

interface SpringApartmentBookingHistory extends CrudRepository<ApartmentBookingHistory, String> {
}
