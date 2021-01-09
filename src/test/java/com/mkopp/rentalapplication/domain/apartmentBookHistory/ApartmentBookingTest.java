package com.mkopp.rentalapplication.domain.apartmentBookHistory;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentBookingTest {

    @Test
    void shouldCreateApartmentBookingStartWithAllRequiredInformation() {
        LocalDateTime bookingDateTime = LocalDateTime.of(2020, 10, 10, 2, 2);
        String ownerId = "123";
        String tenantId = "75";
        LocalDate start = LocalDate.of(2020, 11, 11);
        LocalDate end = LocalDate.of(2020, 11, 19);

        ApartmentBooking actual = ApartmentBooking.start(bookingDateTime, ownerId, tenantId, new BookingPeriod(start, end));

        ApartmentBookingAssertions.assertThat(actual)
                .isStart()
                .hasBookingDateTimeEqualTo(bookingDateTime)
                .hasOwnerIdEqualTo(ownerId)
                .hasTenantIdEqualTo(tenantId)
                .hasBookingPeriodThatHas(start, end);
    }
}