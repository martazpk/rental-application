package com.mkopp.rentalapplication.domain.apartment;

import com.mkopp.rentalapplication.domain.eventchannel.EventChannel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
public class Apartment {
    @Id
    @GeneratedValue
    private String id;
    private String ownerId;
    @Embedded
    private Address address;
    @OneToMany
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

    public Booking book(String tenantId, Period period, EventChannel eventChannel) {
        //publish event
        ApartmentBooked apartmentBooked = ApartmentBooked.create(id, ownerId, tenantId, period);
        eventChannel.publish(apartmentBooked);
        return new Booking(id, tenantId, period);
    }
}
