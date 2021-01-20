package com.mkopp.rentalapplication.domain.hotelBookHistory;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class HotelBookingHistory {
    @Id
    private UUID hotelId;
    private String roomId;
    @OneToMany
    private List<HotelRoomBooking> bookings = new ArrayList<>();

    public HotelBookingHistory(String roomId) {
        this.roomId = roomId;
    }

    public void add(HotelRoomBooking newBooking) {
        bookings.add(newBooking);
    }

    private HotelBookingHistory() {
    }
}
