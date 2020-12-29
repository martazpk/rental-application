package com.mkopp.rentalapplication.domain.apartmentBookHistory;

public class ApartmentBooking {
    private final BookingStep step;
    private final String ownerId;
    private final String tenantId;
    private final BookingPeriod bookingPeriod;

    private ApartmentBooking(BookingStep step, String ownerId, String tenantId, BookingPeriod bookingPeriod) {
        this.step = step;
        this.ownerId = ownerId;
        this.tenantId = tenantId;
        this.bookingPeriod = bookingPeriod;
    }

    public static ApartmentBooking start(String ownerId, String tenantId, BookingPeriod bookingPeriod) {
        return new ApartmentBooking(BookingStep.START, ownerId, tenantId, bookingPeriod);
    }
}
