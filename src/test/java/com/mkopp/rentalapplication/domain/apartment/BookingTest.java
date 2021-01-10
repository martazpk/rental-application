package com.mkopp.rentalapplication.domain.apartment;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class BookingTest {
    String rentalPlaceId = "123";
    String tenantId = "654";
    LocalDate start=LocalDate.of(2020,12,12);
    LocalDate dayBetweenStartAndEnd =LocalDate.of(2020,12,13);
    LocalDate end = LocalDate.of(2020,12,14);

    @Test
    void shouldCreateApartmentBooking() {
        Booking actual = Booking.apartment(rentalPlaceId, tenantId, new Period(start, end));

        BookingAssertions.assertThat(actual)
                .hasRentalPlaceIdEqualTo(rentalPlaceId)
                .hasTenantIdEqualTo(tenantId)
                .hasDays(ImmutableList.of(start, dayBetweenStartAndEnd, end))
                .isApartment()
                .hasBookingStatusOpen();
    }

    @Test
    void shouldCreateHotelBooking() {
        List<LocalDate> days = ImmutableList.of(start, dayBetweenStartAndEnd, end);
        Booking actual = Booking.hotel(rentalPlaceId, tenantId, days);

        BookingAssertions.assertThat(actual)
                .hasRentalPlaceIdEqualTo(rentalPlaceId)
                .hasTenantIdEqualTo(tenantId)
                .hasDays(days)
                .isHotel()
                .hasBookingStatusOpen();
    }
}