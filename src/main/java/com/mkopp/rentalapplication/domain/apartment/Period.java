package com.mkopp.rentalapplication.domain.apartment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
public class Period {
    private LocalDate start;
    private LocalDate end;

    public Period(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    public Period() {
    }
}
