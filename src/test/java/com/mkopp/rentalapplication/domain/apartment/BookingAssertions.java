package com.mkopp.rentalapplication.domain.apartment;

import org.assertj.core.api.Assertions;

import java.time.LocalDate;
import java.util.List;

public class BookingAssertions {
    private static Booking actual;

    private BookingAssertions(Booking actual) {
        this.actual = actual;
    }

    public static BookingAssertions assertThat(Booking actual) {
        return new BookingAssertions(actual);
    }

    public BookingAssertions hasRentalPlaceIdEqualTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("rentalPlaceId", expected);
        return this;
    }

    public BookingAssertions hasTenantIdEqualTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("tenantId", expected);
        return this;
    }


    public BookingAssertions isApartment() {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("rentalType", RentalType.APARTMENT);
        return this;
    }

    public BookingAssertions isHotel() {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("rentalType", RentalType.HOTEL);
        return this;
    }

    public BookingAssertions hasDays(List<LocalDate> expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("days", expected);
        return this;
    }

    public BookingAssertions hasBookingStatusOpen() {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("bookingStatus", BookingStatus.OPEN);
        return this;
    }
}
