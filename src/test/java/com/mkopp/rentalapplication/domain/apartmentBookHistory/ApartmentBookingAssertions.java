package com.mkopp.rentalapplication.domain.apartmentBookHistory;

import org.assertj.core.api.Assertions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ApartmentBookingAssertions {

    private final ApartmentBooking actual;

    private ApartmentBookingAssertions(ApartmentBooking actual) {
        this.actual = actual;
    }

    public static ApartmentBookingAssertions assertThat(ApartmentBooking actual) {
        return new ApartmentBookingAssertions(actual);
    }

    public ApartmentBookingAssertions isStart() {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("step", BookingStep.START);
        return this;
    }

    public ApartmentBookingAssertions hasBookingDateTimeEqualTo(LocalDateTime expected) {
    Assertions.assertThat(actual).hasFieldOrPropertyWithValue("bookingDateTime", expected);
        return this;
    }

    public ApartmentBookingAssertions hasOwnerIdEqualTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("ownerId", expected);
        return this;
    }

    public ApartmentBookingAssertions hasTenantIdEqualTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("tenantId", expected);
        return this;
    }

    public ApartmentBookingAssertions hasBookingPeriodThatHas(LocalDate expectedStart, LocalDate expectedEnd) {
        Assertions.assertThat(actual)
                .hasFieldOrPropertyWithValue("bookingPeriod.start", expectedStart)
                .hasFieldOrPropertyWithValue("bookingPeriod.end", expectedEnd);
        return this;
    }
}
