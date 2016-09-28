package com.skwarek.onlineStore.domain.product.specifications.modules;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Michal on 27.09.2016.
 */
@Embeddable
public class Weight {

    @Column(name = "weight")
    private Integer weight;

    public Weight() { }

    public Weight(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weight)) return false;

        Weight weight1 = (Weight) o;

        return weight != null ? weight.equals(weight1.weight) : weight1.weight == null;
    }

    @Override
    public int hashCode() {
        return weight != null ? weight.hashCode() : 0;
    }

    @Override
    public String toString() {
        return weight + " grams";
    }
}
