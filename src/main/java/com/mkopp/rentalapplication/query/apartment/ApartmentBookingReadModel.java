package com.mkopp.rentalapplication.query.apartment;

import lombok.Getter;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Getter
public class ApartmentBookingReadModel {
    private String step;
    private String ownerId;
    private String tenantId;
    private LocalDate start;
    private LocalDate end;


    public ApartmentBookingReadModel(String step, String ownerId, String tenantId, LocalDate start, LocalDate end) {
        this.step = step;
        this.ownerId = ownerId;
        this.tenantId = tenantId;
        this.start = start;
        this.end = end;
    }

    private ApartmentBookingReadModel() {
    }
}
