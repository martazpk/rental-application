package com.mkopp.rentalapplication.application.commandregistry;

import com.mkopp.rentalapplication.application.booking.AcceptBooking;
import com.mkopp.rentalapplication.application.booking.RejectBooking;

public interface CommandRegistry {
    void register(RejectBooking rejectBooking);

    void register(AcceptBooking acceptBooking);
}
