package com.mkopp.rentalapplication.application.booking;

import com.mkopp.rentalapplication.domain.apartment.Booking;
import com.mkopp.rentalapplication.domain.apartment.BookingRepository;
import org.springframework.context.event.EventListener;

public class BookingCommandHandler {
    private final BookingRepository bookingRepository;

    public BookingCommandHandler(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @EventListener
    public void reject(RejectBooking rejectBooking) {
        Booking booking = bookingRepository.findById(rejectBooking.getBookingId());

        booking.reject();

        bookingRepository.save(booking);
    }
}
