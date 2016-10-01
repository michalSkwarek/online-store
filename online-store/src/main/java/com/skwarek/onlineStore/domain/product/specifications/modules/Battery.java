package com.skwarek.onlineStore.domain.product.specifications.modules;

import javax.persistence.*;

/**
 * Created by Michal on 27.09.2016.
 */
@Embeddable
public class Battery {

    @Column(name = "battery_capacity")
    private Integer capacity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "battery_type_id")
    private BatteryType batteryType;

    public Battery() { }

    public Battery(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public BatteryType getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(BatteryType batteryType) {
        this.batteryType = batteryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Battery)) return false;

        Battery battery = (Battery) o;

        if (capacity != null ? !capacity.equals(battery.capacity) : battery.capacity != null) return false;
        return batteryType != null ? batteryType.equals(battery.batteryType) : battery.batteryType == null;

    }

    @Override
    public int hashCode() {
        int result = capacity != null ? capacity.hashCode() : 0;
        result = 31 * result + (batteryType != null ? batteryType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return capacity + " mAh, " + batteryType;
    }
}
