package com.mkopp.rentalapplication.infrastructure.persistency.jpa.apartment;

import com.google.common.collect.ImmutableMap;
import com.mkopp.rentalapplication.domain.apartment.Apartment;
import com.mkopp.rentalapplication.domain.apartment.ApartmentAssertions;
import com.mkopp.rentalapplication.domain.apartment.ApartmentFactory;
import com.mkopp.rentalapplication.domain.apartment.ApartmentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class JpaApartmentRepositoryIntegrationTest {
    private final ApartmentFactory apartmentFactory = new ApartmentFactory();
    private static final String OWNER_ID = "123";
    private static final String STREET = "zielona";
    private static final String POSTAL_CODE = "32-030";
    private static final String HOUSE_NUMBER = "12";
    private static final String APARTMENT_NUMBER = "12";
    private static final String CITY = "Cracow";
    private static final String COUNTRY = "Poland";
    private static final Map<String, Double> ROOMS_DEFINITION = ImmutableMap.of("toilet", 10.0, "bedroom", 20.0);
    private static final String DESCRIPTION = "Nice place to stay";

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Test
    void shouldThrowExceptionWhenApartmentDoesNotExist() {
        String id = UUID.randomUUID().toString();
        ApartmentDoesNotExistException exc = assertThrows(ApartmentDoesNotExistException.class, () -> apartmentRepository.findById(id));
        Assertions.assertThat(exc.getMessage()).isEqualTo("Apartment with id "+ id +" does not exist.");
    }

    @Test
    @Transactional
    void shouldReturnExistingApartment() {
        Apartment apartment = createApartment();
        String id = apartmentRepository.save(apartment);
        Apartment actual = apartmentRepository.findById(id);

        ApartmentAssertions.assertThat(actual)
                .hasOwnerId(OWNER_ID)
                .hasAddress(STREET, POSTAL_CODE, HOUSE_NUMBER, APARTMENT_NUMBER, CITY, COUNTRY)
                .hasRooms(ROOMS_DEFINITION)
                .hasDescription(DESCRIPTION);
    }

    private Apartment createApartment() {
        return apartmentFactory.create(
                OWNER_ID, STREET, POSTAL_CODE, HOUSE_NUMBER, APARTMENT_NUMBER,
                CITY, COUNTRY, ROOMS_DEFINITION, DESCRIPTION);
    }
}