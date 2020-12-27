package com.mkopp.rentalapplication.infrastructure.persistency.jpa.apartment;

import com.mkopp.rentalapplication.domain.apartment.Apartment;
import org.springframework.data.repository.CrudRepository;

public interface SpringJpaApartmentRepository extends CrudRepository<Apartment, String> {
}
