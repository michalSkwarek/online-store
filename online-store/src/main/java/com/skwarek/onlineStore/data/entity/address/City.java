package com.skwarek.onlineStore.data.entity.address;

import com.skwarek.onlineStore.data.entity.BaseEntity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Michal on 23.09.2016.
 */
@Entity
@Table(name = "city")
public class City extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 3193815843479979880L;

    @NotEmpty(message = "{City.name.validation.notEmpty}")
    @Column(name = "name")
    private String name;

    public City() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;

        City city = (City) o;

        return name != null ? name.equals(city.name) : city.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "City{" +
                "name=" + name +
                '}';
    }
}
