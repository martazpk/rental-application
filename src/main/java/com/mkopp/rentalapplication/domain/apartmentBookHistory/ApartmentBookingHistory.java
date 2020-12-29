package com.mkopp.rentalapplication.domain.apartmentBookHistory;

import java.util.ArrayList;
import java.util.List;

public class ApartmentBookingHistory {
    private final String apartmentId;
    private List<ApartmentBooking> bookings = new ArrayList<>();

    public ApartmentBookingHistory(String apartmentId) {
        this.apartmentId = apartmentId;
    }

    public void add(ApartmentBooking apartmentBooking) {
        bookings.add(apartmentBooking);
    }
}
