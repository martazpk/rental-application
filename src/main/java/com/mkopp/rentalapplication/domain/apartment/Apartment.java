package com.mkopp.rentalapplication.domain.apartment;

import com.mkopp.rentalapplication.domain.eventchannel.EventChannel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "APARTMENT")
public class Apartment {
    @Id
    @GeneratedValue
    private String id;
    private String ownerId;
    @Embedded
    private Address address;
    @ElementCollection
    private List<Room> rooms;
    private String description;

    Apartment(String ownerId, Address address, List<Room> rooms, String description) {
        this.ownerId = ownerId;
        this.address = address;
        this.rooms = rooms;
        this.description = description;
    }

    protected Apartment() {
    }

    public Booking book(String tenantId, Period period, RentalType rentalType, EventChannel eventChannel) {
        //publish event
        ApartmentBooked apartmentBooked = ApartmentBooked.create(id, ownerId, tenantId, rentalType, period);
        eventChannel.publish(apartmentBooked);
        return Booking.apartment(id, tenantId, period);
    }

}
