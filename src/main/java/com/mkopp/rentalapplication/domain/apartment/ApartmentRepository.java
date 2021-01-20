package com.mkopp.rentalapplication.domain.apartment;

public interface ApartmentRepository {
    String save(Apartment apartment);

    Apartment findById(String id);
}
