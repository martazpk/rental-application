package com.mkopp.rentalapplication.infrastructure.persistency.jpa.apartment;

import com.mkopp.rentalapplication.domain.apartment.Apartment;
import com.mkopp.rentalapplication.domain.apartment.ApartmentRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaApartmentRepository implements ApartmentRepository {
    private final SpringJpaApartmentRepository springJpaApartmentRepository;

    public JpaApartmentRepository(SpringJpaApartmentRepository springJpaApartmentRepository) {
        this.springJpaApartmentRepository = springJpaApartmentRepository;
    }

    @Override
    public void save(Apartment apartment) {
        springJpaApartmentRepository.save(apartment);
    }

    @Override
    public Apartment findById(String id) {
        return springJpaApartmentRepository.findById(id).get();
    }
}
