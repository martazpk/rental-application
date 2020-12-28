package com.mkopp.rentalapplication.domain.apartment;

import javax.persistence.*;
import java.util.List;
@Entity
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

    public void book(String tenantId, Period period) {
        //publish event
        ApartmentBooked apartmentBooked = ApartmentBooked.create(id, ownerId, tenantId, period);
    }
}
