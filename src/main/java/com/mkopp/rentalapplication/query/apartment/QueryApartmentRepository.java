package com.mkopp.rentalapplication.query.apartment;

public class QueryApartmentRepository {
    private final SpringQueryApartmentRepository springQueryApartmentRepository;

    public QueryApartmentRepository(SpringQueryApartmentRepository springQueryApartmentRepository) {
        this.springQueryApartmentRepository = springQueryApartmentRepository;
    }

    public Iterable<ApartmentReadModel> getAll() {
        return springQueryApartmentRepository.findAll();
    }
}
