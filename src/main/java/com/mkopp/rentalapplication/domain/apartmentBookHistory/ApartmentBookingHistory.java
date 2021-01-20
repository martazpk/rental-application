package com.mkopp.rentalapplication.domain.apartmentBookHistory;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "APARTMENT_BOOKING_HOSTORY")
public class ApartmentBookingHistory {
    @Id
    private String apartmentId;
    @OneToMany
    private List<ApartmentBooking> bookings = new ArrayList<>();

    public ApartmentBookingHistory(String apartmentId) {
        this.apartmentId = apartmentId;
    }

    private ApartmentBookingHistory() {
    }

    public void add(ApartmentBooking apartmentBooking) {
        bookings.add(apartmentBooking);
    }
}
