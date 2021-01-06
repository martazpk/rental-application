package com.mkopp.rentalapplication.infrastructure.rest.api.apartment;

import com.mkopp.rentalapplication.application.apartment.ApartmentApplicationService;
import com.mkopp.rentalapplication.query.apartment.ApartmentDetails;
import com.mkopp.rentalapplication.query.apartment.ApartmentReadModel;
import com.mkopp.rentalapplication.query.apartment.QueryApartmentRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apartment")
public class ApartmentRestController {
    private final ApartmentApplicationService apartmentApplicationService;
    private final QueryApartmentRepository queryApartmentRepository;

    public ApartmentRestController(ApartmentApplicationService apartmentApplicationService, QueryApartmentRepository queryApartmentRepository) {
        this.apartmentApplicationService = apartmentApplicationService;
        this.queryApartmentRepository = queryApartmentRepository;
    }

    @PostMapping
    public void add(@RequestBody ApartmentDto apartmentDto) {
        apartmentApplicationService.add(apartmentDto.getOwnerId(), apartmentDto.getStreet(), apartmentDto.getPostalCode(),
                apartmentDto.getHouseNumber(), apartmentDto.getApartmentNumber(), apartmentDto.getCity(), apartmentDto.getCountry(),
                apartmentDto.getDescription(), apartmentDto.getRoomsDefinition());
    }

    @PutMapping("/book/{id}")
    public void book(@PathVariable String id, ApartmentBookingDto apartmentBookingDto) {
        apartmentApplicationService.book(
                id, apartmentBookingDto.getTenantId(), apartmentBookingDto.getRentalType(), apartmentBookingDto.getStart(), apartmentBookingDto.getEnd());
    }

    @GetMapping
    public Iterable<ApartmentReadModel> getAll() {
        return queryApartmentRepository.getAll();
    }

    @GetMapping("/{id}")
    public ApartmentDetails findByid(@PathVariable String id){
        return queryApartmentRepository.findById(id);
    }

}
