package com.mkopp.rentalapplication.domain.apartment;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class ApartmentBookedTest {

    @Test
    void shouldCreateWithAllInformation() {
        String apartmentId = "123";
        String ownerId = "456";
        String tenantId = "878";
        RentalType rentalType = RentalType.HOTEL;
        LocalDate periodStart = LocalDate.of(2020,12,12);
        LocalDate periodEnd = LocalDate.of(2020, 12, 20);
        Period period = new Period(periodStart, periodEnd);

        ApartmentBooked actual = ApartmentBooked.create(apartmentId, ownerId, tenantId, rentalType, period);

        assertThat(actual.getEventCreationDateTime()).isBefore(LocalDateTime.from(LocalDateTime.now().plusSeconds(1)));
        assertThat(actual.getEventId()).matches(Pattern.compile("[0-9a-z\\-]{36}"));
        assertThat(actual.getPeriodStart()).isEqualTo(periodStart);
        assertThat(actual.getPeriodEnd()).isEqualTo(periodEnd);

    }
}