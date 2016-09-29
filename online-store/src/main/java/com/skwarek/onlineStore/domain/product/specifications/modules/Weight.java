package com.skwarek.onlineStore.domain.product.specifications.modules;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Michal on 27.09.2016.
 */
@Embeddable
public class Weight {

    @Column(name = "weight")
    private Integer value;

    public Weight() { }

    public Weight(Integer weight) {
        this.value = weight;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weight)) return false;

        Weight weight = (Weight) o;

        return value != null ? value.equals(weight.value) : weight.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return value + " grams";
    }
}