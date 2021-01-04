package com.mkopp.rentalapplication.infrastructure.persistency.jpa.booking;

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

    @Override
    public Booking findById(String bookingId) {
       return springBookingRepository.findById(bookingId).orElseThrow(BookingNotFoundException::new);
    }
}
