package com.mkopp.rentalapplication.domain.apartment;

import javax.persistence.Embeddable;

@Embeddable
class SquereMeter {
    private Double size;

    SquereMeter(Double size) {
        this.size = size;
    }

    private SquereMeter() {
    }

    private Double getSize() {
        return size;
    }

    private void setSize(Double size) {
        this.size = size;
    }
}
