package com.mkopp.rentalapplication.domain.apartmentBookHistory;

public interface ApartmentBookingHistoryRepository {

    boolean existsFor(String apartmentId);

    ApartmentBookingHistory findFor(String id);

    void save(ApartmentBookingHistory apartmentBookingHistory);
}
