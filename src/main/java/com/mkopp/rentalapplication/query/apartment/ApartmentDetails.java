package com.mkopp.rentalapplication.query.apartment;

import lombok.Getter;

@Getter
public class ApartmentDetails {
    private final ApartmentReadModel apartment;
    private final ApartmentBookingHistoryReadModel bookingHistory;

    public ApartmentDetails(ApartmentReadModel apartment, ApartmentBookingHistoryReadModel bookingHistory) {
        this.apartment = apartment;
        this.bookingHistory = bookingHistory;
    }
}
