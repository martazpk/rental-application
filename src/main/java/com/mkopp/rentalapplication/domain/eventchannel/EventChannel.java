package com.mkopp.rentalapplication.domain.eventchannel;

import com.mkopp.rentalapplication.domain.apartment.ApartmentBooked;

public interface EventChannel {
    void publish(ApartmentBooked apartmentBooked);
}
