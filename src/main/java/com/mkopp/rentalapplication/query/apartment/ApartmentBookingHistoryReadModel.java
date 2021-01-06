package com.mkopp.rentalapplication.query.apartment;


import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "APARTMENT_BOOKING_HOSTORY")
@Getter
public class ApartmentBookingHistoryReadModel {
    private final String apartmentId;
    private List<ApartmentBookingReadModel> bookings = new ArrayList<>();

    public ApartmentBookingHistoryReadModel(String apartmentId) {
        this.apartmentId = apartmentId;
    }
}
