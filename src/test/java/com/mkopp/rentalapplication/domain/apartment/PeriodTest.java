package com.mkopp.rentalapplication.domain.apartment;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PeriodTest {
    @Test
    void shouldMapTpDays() {
        LocalDate start = LocalDate.of(2021, 01, 03);
        LocalDate end = LocalDate.of(2021, 01, 04);
        Period period = new Period(start, end);
        List<LocalDate> days = period.asDays();
        System.out.println(days);
        assertThat(days).hasSize(2);
    }

    @Test
    void shouldReturnExactlyOneDayWhenStartAndEndAreTheSame() {
        LocalDate day = LocalDate.of(2021, 01, 03);
        Period period = new Period(day, day);

        List<LocalDate> actual = period.asDays();

        assertThat(actual).containsExactly(day);
    }
}