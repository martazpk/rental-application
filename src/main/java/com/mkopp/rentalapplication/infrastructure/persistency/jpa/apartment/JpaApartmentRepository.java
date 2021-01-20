package com.mkopp.rentalapplication.infrastructure.persistency.jpa.apartment;

import com.mkopp.rentalapplication.domain.apartment.Apartment;
import com.mkopp.rentalapplication.domain.apartment.ApartmentRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class JpaApartmentRepository implements ApartmentRepository {
    private final SpringJpaApartmentRepository springJpaApartmentRepository;

    public JpaApartmentRepository(SpringJpaApartmentRepository springJpaApartmentRepository) {
        this.springJpaApartmentRepository = springJpaApartmentRepository;
    }

    @Override
    public String save(Apartment apartment) {
        return springJpaApartmentRepository.save(apartment).id();
    }

    @Override
    public Apartment findById(String id) {

        return springJpaApartmentRepository.findById(UUID.fromString(id))
                .orElseThrow( () -> new ApartmentDoesNotExistException(id));
    }
}
