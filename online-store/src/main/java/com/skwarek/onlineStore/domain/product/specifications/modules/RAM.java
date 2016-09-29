package com.skwarek.onlineStore.domain.product.specifications.modules;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Michal on 30.09.2016.
 */
@Embeddable
public class RAM {

    @Column(name = "ram")
    private Integer value;

    public RAM() { }

    public RAM(Integer value) {
        this.value = value;
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
        if (!(o instanceof RAM)) return false;

        RAM ram = (RAM) o;

        return value != null ? value.equals(ram.value) : ram.value == null;

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return value + " GB";
    }
}
