package com.mkopp.rentalapplication.domain.apartmentBookHistory;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "APARTMENT_BOOKING")
public class ApartmentBooking {
    private final BookingStep step;
    private final String ownerId;
    private final String tenantId;
    @Embedded
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
