package com.mkopp.rentalapplication.infrastructure.persistency.jpa.apartmentBookHistory;

import com.mkopp.rentalapplication.domain.apartmentBookHistory.ApartmentBookingHistory;
import com.mkopp.rentalapplication.domain.apartmentBookHistory.ApartmentBookingHistoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaApartmentBookingHistoryRepository implements ApartmentBookingHistoryRepository {
    private final SpringApartmentBookingHistory springApartmentBookingHistory;

    public JpaApartmentBookingHistoryRepository(SpringApartmentBookingHistory springApartmentBookingHistory) {
        this.springApartmentBookingHistory = springApartmentBookingHistory;
    }

    @Override
    public boolean existsFor(String apartmentId) {
        return springApartmentBookingHistory.existsById(apartmentId);
    }

    @Override
    public ApartmentBookingHistory findFor(String id) {
        return springApartmentBookingHistory.findById(id).get();
    }

    @Override
    public void save(ApartmentBookingHistory apartmentBookingHistory) {
        springApartmentBookingHistory.save(apartmentBookingHistory);
    }
}
