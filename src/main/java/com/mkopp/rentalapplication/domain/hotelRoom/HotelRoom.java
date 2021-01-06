package com.mkopp.rentalapplication.domain.hotelRoom;

import com.mkopp.rentalapplication.domain.apartment.Booking;
import com.mkopp.rentalapplication.domain.eventchannel.EventChannel;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "HOTEL_ROOM")
public class HotelRoom {
    @Id
    @GeneratedValue
    private String id;
    private String hotelId;
    private int number;
    private String description;
    @OneToMany
    private List<Space> spaces;

    HotelRoom(String hotelId, int number, String description, List<Space> spaces) {
        this.hotelId = hotelId;
        this.number = number;
        this.description = description;
        this.spaces = spaces;
    }

    protected HotelRoom() {
    }

    public Booking book(String tenantId, List<LocalDate> dates, EventChannel eventChannel) {
        HotelRoomBooked hotelRoomBooked = HotelRoomBooked.create(id, hotelId, tenantId, dates);
        eventChannel.publish(hotelRoomBooked);
        return Booking.hotelRoom(id, tenantId, dates);
    }
}
