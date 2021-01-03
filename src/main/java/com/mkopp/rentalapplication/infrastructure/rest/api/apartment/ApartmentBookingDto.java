package com.mkopp.rentalapplication.infrastructure.rest.api.apartment;

import com.mkopp.rentalapplication.domain.apartment.RentalType;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ApartmentBookingDto {
    private final String tenantId;
    private final RentalType rentalType;
    private final LocalDate start;
    private final LocalDate end;

    public ApartmentBookingDto(String tenantId, RentalType rentalType, LocalDate start, LocalDate end) {
        this.tenantId = tenantId;
        this.rentalType = rentalType;
        this.start = start;
        this.end = end;
    }
}
