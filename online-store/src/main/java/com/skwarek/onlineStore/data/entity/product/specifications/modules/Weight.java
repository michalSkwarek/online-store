package com.skwarek.onlineStore.data.entity.product.specifications.modules;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Michal on 27.09.2016.
 */
@Embeddable
public class Weight implements Serializable {

    private static final long serialVersionUID = 7268529761943739781L;

    @Column(name = "weight")
    private Double value;

    public Weight() { }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
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
        return value + ((value > 20) ? " grams" : " kg");
    }
}
