package com.skwarek.onlineStore.domain.product.specifications.modules;

import javax.persistence.*;

/**
 * Created by Michal on 27.09.2016.
 */
@Entity
@Table(name = "battery")
public class Battery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "type")
    private String type;

    public Battery(Integer capacity, String type) {
        this.capacity = capacity;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

        if (id != null ? !id.equals(battery.id) : battery.id != null) return false;
        if (capacity != null ? !capacity.equals(battery.capacity) : battery.capacity != null) return false;
        return type != null ? type.equals(battery.type) : battery.type == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return capacity + " mAh, " + type;
    }
}
