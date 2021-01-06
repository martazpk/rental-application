package com.mkopp.rentalapplication.query.apartment;

import org.springframework.data.repository.CrudRepository;

public interface SpringQueryApartmentRepository extends CrudRepository<ApartmentReadModel, String> {
}
