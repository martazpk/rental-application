package com.mkopp.rentalapplication.infrastructure.persistency.jpa.apartment;

import com.mkopp.rentalapplication.domain.apartment.Apartment;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

interface SpringJpaApartmentRepository extends CrudRepository<Apartment, UUID> {
}
