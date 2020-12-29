package com.mkopp.rentalapplication.domain.apartmentBookHistory;

import java.time.LocalDate;

public class BookingPeriod {
    private final LocalDate start;
    private final LocalDate end;

    public BookingPeriod(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }
}
