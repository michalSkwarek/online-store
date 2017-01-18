package com.skwarek.onlineStore.data.entity.address;

import com.skwarek.onlineStore.data.entity.BaseEntity;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Michal on 23.09.2016.
 */
@Entity
@Table(name = "city")
public class City extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -3271934192695286533L;

    @NotEmpty(message = "{City.name.validation.notEmpty}")
    @Column(name = "name")
    private String name;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "city")
    private Set<Address> addresses = new HashSet<>();

    public City() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
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
                "}";
    }
}
