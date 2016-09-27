package com.skwarek.onlineStore.domain.product.specifications.modules;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Michal on 27.09.2016.
 */
@Embeddable
public class PowerSupply {

    @Column(name = "power_supply")
    private Integer power;

    public PowerSupply(Integer power) {
        this.power = power;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PowerSupply)) return false;

        PowerSupply that = (PowerSupply) o;

        return power != null ? power.equals(that.power) : that.power == null;
    }

    @Override
    public int hashCode() {
        return power != null ? power.hashCode() : 0;
    }

    @Override
    public String toString() {
        return power + " W";
    }
}
