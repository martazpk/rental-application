package com.mkopp.rentalapplication.domain.apartment;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.mkopp.rentalapplication.domain.apartment.RentalType.HOTEL;
import static org.assertj.core.api.Assertions.assertThat;

class BookingAcceptedTest {

    @Test
    void shouldCreteBookingAcceptedWithAllRequiredInformation() {
        String rentalPlaceId = "123";
        String tenantId = "1234";
        LocalDate day1 = LocalDate.of(2020, 12, 12);
        LocalDate day2 = LocalDate.of(2020, 12, 13);
        List<LocalDate> days = ImmutableList.of(day1, day2);
        BookingAccepted actual = BookingAccepted.create(HOTEL, rentalPlaceId, tenantId, days);

        assertThat(actual.getCreationDate())
                .isBefore(LocalDateTime.now().plusSeconds(1))
                .isAfter(LocalDateTime.now().minusSeconds(1));
        assertThat(actual.getDays()).containsExactlyElementsOf(days);
        assertThat(actual.getTenantId()).isEqualTo(tenantId);
        assertThat(actual.getRentalPlaceId()).isEqualTo(rentalPlaceId);
        assertThat(actual.getRentalType()).isEqualTo("HOTEL");
        assertThat(actual.getEventId()).matches("[a-z0-9\\-]{36}");
    }
}