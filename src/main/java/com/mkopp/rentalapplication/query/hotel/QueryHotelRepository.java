package com.mkopp.rentalapplication.query.hotel;


public class QueryHotelRepository {
    private final SpringHotelReadModelRepository springRepository;

    public QueryHotelRepository(SpringHotelReadModelRepository springRepository) {
        this.springRepository = springRepository;
    }

    public Iterable<HotelReadModel> findAll() {
        return springRepository.findAll();
    }
}
