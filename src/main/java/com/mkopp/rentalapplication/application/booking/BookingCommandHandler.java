package com.mkopp.rentalapplication.application.booking;

import com.mkopp.rentalapplication.domain.apartment.Booking;
import com.mkopp.rentalapplication.domain.apartment.BookingRepository;
import com.mkopp.rentalapplication.domain.eventchannel.EventChannel;
import org.springframework.context.event.EventListener;

public class BookingCommandHandler {
    private final BookingRepository bookingRepository;
    private final EventChannel eventChannel;

    public BookingCommandHandler(BookingRepository bookingRepository, EventChannel eventChannel) {
        this.bookingRepository = bookingRepository;
        this.eventChannel = eventChannel;
    }

    @EventListener
    public void reject(RejectBooking rejectBooking) {
        Booking booking = bookingRepository.findById(rejectBooking.getBookingId());

        booking.reject();

        bookingRepository.save(booking);
    }

    @EventListener
    public void accept(AcceptBooking acceptBooking){
        Booking booking = bookingRepository.findById(acceptBooking.getId());

        booking.accept(eventChannel);

        bookingRepository.save(booking);
    }
}
