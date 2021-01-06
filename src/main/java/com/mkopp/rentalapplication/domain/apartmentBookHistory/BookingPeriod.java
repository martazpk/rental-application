package com.mkopp.rentalapplication.domain.apartmentBookHistory;

import javax.persistence.Embeddable;
import java.time.LocalDate;
@Embeddable
public class BookingPeriod {
    private LocalDate start;
    private LocalDate end;

    public BookingPeriod(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    private BookingPeriod() {

    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }
}
