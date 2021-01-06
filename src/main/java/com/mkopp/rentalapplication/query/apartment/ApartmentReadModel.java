package com.mkopp.rentalapplication.query.apartment;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Table(name = "APARTMENT")
public class ApartmentReadModel {
    @Id
    @GeneratedValue
    private String id;

    private String ownerId;
    private String street;
    private String postalCode;
    private String houseNumber;
    private String apartmentNumber;
    private String city;
    private String country;
    private String description;
    @OneToMany
    private List<RoomReadModel> rooms;

    public ApartmentReadModel(String id, String ownerId, String street, String postalCode, String houseNumber,
                              String apartmentNumber, String city, String country, String description, List<RoomReadModel> rooms) {
        this.id = id;
        this.ownerId = ownerId;
        this.street = street;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.city = city;
        this.country = country;
        this.description = description;
        this.rooms = rooms;
    }

    public ApartmentReadModel() {
    }
}
