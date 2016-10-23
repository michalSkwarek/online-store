package com.skwarek.onlineStore.data.entity.product.specifications.modules;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Michal on 27.09.2016.
 */
@Embeddable
public class Battery implements Serializable {

    private static final long serialVersionUID = -6399133713133458317L;

    @Column(name = "battery_capacity")
    private Integer capacity;

    @Column(name = "battery_type")
    private String type;

    public Battery() { }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Battery)) return false;

        Battery battery = (Battery) o;

        if (capacity != null ? !capacity.equals(battery.capacity) : battery.capacity != null) return false;
        return type != null ? type.equals(battery.type) : battery.type == null;

    }

    @Override
    public int hashCode() {
        int result = capacity != null ? capacity.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return capacity + " mAh, " + type;
    }
}
