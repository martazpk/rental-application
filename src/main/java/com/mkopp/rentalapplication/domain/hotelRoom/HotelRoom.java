package com.mkopp.rentalapplication.domain.hotelRoom;

import com.mkopp.rentalapplication.domain.apartment.Booking;
import com.mkopp.rentalapplication.domain.eventchannel.EventChannel;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "HOTEL_ROOM")
public class HotelRoom {
    @Id
    @GeneratedValue
    private UUID id;
    private String hotelId;
    private int number;
    private String description;
    @ElementCollection
    @Column(name = "space list")
    private List<Space> spaces;

    HotelRoom(String hotelId, int number, String description, List<Space> spaces) {
        this.hotelId = hotelId;
        this.number = number;
        this.description = description;
        this.spaces = spaces;
    }

    private HotelRoom() {
    }

    public Booking book(String tenantId, List<LocalDate> dates, EventChannel eventChannel) {
        HotelRoomBooked hotelRoomBooked = HotelRoomBooked.create(id(), hotelId, tenantId, dates);
        eventChannel.publish(hotelRoomBooked); 
        return Booking.hotel(id(), tenantId, dates);
    }

    public String id() {
        return id.toString();
    }
}
