package com.skwarek.onlineStore.data.entity.product.specifications.modules;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Michal on 27.09.2016.
 */
@Embeddable
public class PowerSupply implements Serializable {

    private static final long serialVersionUID = 2063060542907019156L;

    @Column(name = "power_supply")
    private Integer power;

    public PowerSupply() { }

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
