package com.mkopp.rentalapplication.query.hotel;

import org.springframework.stereotype.Repository;

@Repository
public class QueryHotelRepository {
    private final SpringHotelReadModelRepository springRepository;

    public QueryHotelRepository(SpringHotelReadModelRepository springRepository) {
        this.springRepository = springRepository;
    }

    public Iterable<HotelReadModel> findAll() {
        return springRepository.findAll();
    }
}
