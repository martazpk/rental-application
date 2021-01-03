package com.mkopp.rentalapplication.domain.apartment;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private String id;
    private String apartmentId;
    private String tenantId;
    @Embedded
    private Period period;

    public Booking() {
    }

    Booking(String apartmentId, String tenantId, Period period) {
        this.apartmentId = apartmentId;
        this.tenantId = tenantId;
        this.period = period;
    }
}
