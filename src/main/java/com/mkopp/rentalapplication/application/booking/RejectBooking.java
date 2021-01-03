package com.mkopp.rentalapplication.application.booking;

public class RejectBooking {
    private final String bookingId;

    public RejectBooking(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingId() {
        return bookingId;
    }
}

