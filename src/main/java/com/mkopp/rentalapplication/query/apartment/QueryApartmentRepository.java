package com.mkopp.rentalapplication.query.apartment;

public class QueryApartmentRepository {
    private final SpringQueryApartmentRepository springQueryApartmentRepository;
    private final SpringQueryBookingRepository bookingRepository;

    public QueryApartmentRepository(SpringQueryApartmentRepository springQueryApartmentRepository, SpringQueryBookingRepository bookingRepository) {
        this.springQueryApartmentRepository = springQueryApartmentRepository;
        this.bookingRepository = bookingRepository;
    }

    public Iterable<ApartmentReadModel> getAll() {
        return springQueryApartmentRepository.findAll();
    }

    public ApartmentDetails findById(String id) {
        ApartmentReadModel apartmentReadModel = springQueryApartmentRepository.findById(id).get();
        ApartmentBookingHistoryReadModel apartmentBookingHistoryReadModel = bookingRepository.findById(id).get();
        return new ApartmentDetails(apartmentReadModel, apartmentBookingHistoryReadModel);
    }
}
