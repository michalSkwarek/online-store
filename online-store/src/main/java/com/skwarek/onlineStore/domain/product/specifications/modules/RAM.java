package com.skwarek.onlineStore.domain.product.specifications.modules;

import javax.persistence.*;

/**
 * Created by Michal on 30.09.2016.
 */
@Embeddable
public class RAM {

    @Column(name = "ram")
    private Integer value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ram_type_id")
    private RAMType ramType;

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

    public RAMType getRamType() {
        return ramType;
    }

    public void setRamType(RAMType ramType) {
        this.ramType = ramType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RAM)) return false;

        RAM ram = (RAM) o;

        if (value != null ? !value.equals(ram.value) : ram.value != null) return false;
        return ramType != null ? ramType.equals(ram.ramType) : ram.ramType == null;

    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (ramType != null ? ramType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return value + " GB" +
                ((ramType == null) ? "" : " " + ramType);
    }
}
