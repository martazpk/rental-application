package com.mkopp.rentalapplication.domain.apartment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<LocalDate> asDays() {
        return start.datesUntil(end.plusDays(1)).collect(Collectors.toList());
    }

}
