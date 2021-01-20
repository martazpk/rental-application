package com.mkopp.rentalapplication.infrastructure.persistency.jpa.hotelroom;

public class HotelRoomDoesNotExistException extends RuntimeException{
    public HotelRoomDoesNotExistException(String id) {
        super("Hotel room " + id +" does not exist.");
    }
}
