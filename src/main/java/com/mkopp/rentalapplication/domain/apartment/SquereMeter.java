package com.mkopp.rentalapplication.domain.apartment;

import javax.persistence.Embeddable;

@Embeddable
class SquereMeter {
    private Double size;

    SquereMeter(Double size) {
        this.size = size;
    }

    protected SquereMeter() {
    }
}
