package com.mkopp.rentalapplication.domain.apartmentBookHistory;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "APARTMENT_BOOKING")
public class ApartmentBooking {
    private final LocalDateTime bookingDateTime;
    private final BookingStep step;
    private final String ownerId;
    private final String tenantId;
    @Embedded
    private final BookingPeriod bookingPeriod;

    private ApartmentBooking(LocalDateTime bookingDateTime, BookingStep step, String ownerId, String tenantId, BookingPeriod bookingPeriod) {
        this.bookingDateTime = bookingDateTime;
        this.step = step;
        this.ownerId = ownerId;
        this.tenantId = tenantId;
        this.bookingPeriod = bookingPeriod;
    }

    public static ApartmentBooking start(LocalDateTime bookingDateTime, String ownerId, String tenantId, BookingPeriod bookingPeriod) {
        return new ApartmentBooking(bookingDateTime, BookingStep.START, ownerId, tenantId, bookingPeriod);
    }
}
