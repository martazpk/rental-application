package com.mkopp.rentalapplication.infrastructure.persistency.jpa.apartmentBookHistory;

import com.mkopp.rentalapplication.domain.apartmentBookHistory.ApartmentBookingHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SpringApartmentBookingHistory extends CrudRepository<ApartmentBookingHistory, String> {
}
