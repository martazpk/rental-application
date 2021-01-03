package com.mkopp.rentalapplication.domain.apartment;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private String id;
    @Enumerated(EnumType.STRING)
    private RentalType rentalType;
    private String apartmentId;
    private String tenantId;
    private List<LocalDate> dates;

    public Booking() {
    }

    private Booking(RentalType rentalType, String apartmentId, String tenantId, List<LocalDate> dates) {
        this.rentalType = rentalType;
        this.apartmentId = apartmentId;
        this.tenantId = tenantId;
        this.dates = dates;
    }

    public static Booking apartment(String rentalPlaceId, String tenantId, Period period) {
        List<LocalDate> dates = period.asDays();
        return new Booking(RentalType.APARTMENT, rentalPlaceId, tenantId, dates);
    }

    public static Booking hotelRoom(String rentalPlaceId, String tenantId, List<LocalDate> dates) {
        return new Booking(RentalType.HOTEL, rentalPlaceId, tenantId, dates);
    }
}
