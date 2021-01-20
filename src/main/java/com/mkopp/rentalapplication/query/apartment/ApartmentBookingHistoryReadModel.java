package com.mkopp.rentalapplication.query.apartment;


import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "APARTMENT_BOOKING_HISTORY")
@Getter
public class ApartmentBookingHistoryReadModel {
    @Id
    private UUID apartmentId;
    @ElementCollection
    private List<ApartmentBookingReadModel> bookings = new ArrayList<>();

    private ApartmentBookingHistoryReadModel() {
    }
}
