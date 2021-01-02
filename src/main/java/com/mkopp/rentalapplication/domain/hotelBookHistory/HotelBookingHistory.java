package com.mkopp.rentalapplication.domain.hotelBookHistory;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class HotelBookingHistory {
    @Id
    private final String roomId;
    private final String hotelId;
    private final List<HotelRoomBooking> bookings = new ArrayList<>();

    public HotelBookingHistory(String hotelId, String roomId) {
        this.hotelId = hotelId;
        this.roomId = roomId;
    }

    public void add(HotelRoomBooking newBooking) {
        bookings.add(newBooking);
    }
}
