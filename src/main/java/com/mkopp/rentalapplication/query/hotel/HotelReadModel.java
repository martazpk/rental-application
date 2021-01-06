package com.mkopp.rentalapplication.query.hotel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HOTELS")
public class HotelReadModel {
    @Id
    @GeneratedValue
    private String id;
    private String name;
    private String street;
    private String buildingNumber;
    private String postalCode;
    private String city;
    private String country;
}
