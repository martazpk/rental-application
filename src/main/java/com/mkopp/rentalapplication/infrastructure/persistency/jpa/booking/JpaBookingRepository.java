package com.mkopp.rentalapplication.infrastructure.persistency.jpa.booking;

import com.mkopp.rentalapplication.domain.apartment.Booking;
import com.mkopp.rentalapplication.domain.apartment.BookingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class JpaBookingRepository implements BookingRepository {
    private final SpringBookingRepository springBookingRepository;

    public JpaBookingRepository(SpringBookingRepository springBookingRepository) {
        this.springBookingRepository = springBookingRepository;
    }

    @Override
    public String save(Booking booking) {
     return springBookingRepository.save(booking).id();
    }

    @Override
    public Booking findById(String bookingId) {
       return springBookingRepository.findById(UUID.fromString(bookingId)).orElseThrow(BookingNotFoundException::new);
    }
}
