package com.mkopp.rentalapplication.infrastructure.persistency.jpa.apartment;

public class ApartmentDoesNotExistException extends RuntimeException{
    public ApartmentDoesNotExistException(String id) {
        super("Apartment with id " + id +" does not exist.");
    }
}
