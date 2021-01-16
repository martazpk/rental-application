package com.mkopp.rentalapplication.infrastructure.persistency.jpa.apartment;

import com.mkopp.rentalapplication.domain.apartment.ApartmentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class JpaApartmentRepositoryIntegrationTest {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Test
    void shouldThrowExceptionWhenApartmentDoesNotExist() {
        ApartmentDoesNotExistException exc = assertThrows(ApartmentDoesNotExistException.class, () -> apartmentRepository.findById("123"));
        Assertions.assertThat(exc.getMessage()).isEqualTo("Apartment with id 123 does not exist.");
    }
}