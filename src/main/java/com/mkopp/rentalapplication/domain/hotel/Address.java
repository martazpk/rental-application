package com.mkopp.rentalapplication.domain.hotel;

import javax.persistence.Embeddable;

@Embeddable
class Address {
    private String street;
    private String buildingNumber;
    private String postalCode;
    private String city;
    private String country;

    Address(String street, String buildingNumber, String postalCode, String city, String country) {
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    protected Address() {
    }
}
