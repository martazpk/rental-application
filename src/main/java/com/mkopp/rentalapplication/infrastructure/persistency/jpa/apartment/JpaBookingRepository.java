package com.mkopp.rentalapplication.infrastructure.persistency.jpa.apartment;

import com.mkopp.rentalapplication.domain.apartment.Booking;
import com.mkopp.rentalapplication.domain.apartment.BookingRepository;

public class JpaBookingRepository implements BookingRepository {
    private final SpringBookingRepository springBookingRepository;

    public JpaBookingRepository(SpringBookingRepository springBookingRepository) {
        this.springBookingRepository = springBookingRepository;
    }

    @Override
    public void save(Booking booking) {
        springBookingRepository.save(booking);
    }
}
