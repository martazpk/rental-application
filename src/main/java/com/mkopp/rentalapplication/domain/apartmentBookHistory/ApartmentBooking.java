package com.mkopp.rentalapplication.domain.apartmentBookHistory;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "APARTMENT_BOOKING")
public class ApartmentBooking {
    @Id
    @GeneratedValue
    private String id;
    private LocalDateTime bookingDateTime;
    private BookingStep step;
    private String ownerId;
    private String tenantId;
    @Embedded
    private BookingPeriod bookingPeriod;

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

    private ApartmentBooking() {
    }
}
