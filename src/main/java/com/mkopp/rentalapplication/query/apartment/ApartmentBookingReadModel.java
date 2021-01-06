package com.mkopp.rentalapplication.query.apartment;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "APARTMENT_BOOKING")
@Getter
public class ApartmentBookingReadModel {
    private final String step;
    private final String ownerId;
    private final String tenantId;
    private final LocalDate start;
    private final LocalDate end;


    public ApartmentBookingReadModel(String step, String ownerId, String tenantId, LocalDate start, LocalDate end) {
        this.step = step;
        this.ownerId = ownerId;
        this.tenantId = tenantId;
        this.start = start;
        this.end = end;
    }
}
