package com.skwarek.onlineStore.data.entity.product.specifications.modules;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Michal on 30.09.2016.
 */
@Embeddable
public class RAM implements Serializable {

    private static final long serialVersionUID = 1012756462133620058L;

    @NotNull(message = "{Specifications.ram.value.validation.notNull}")
    @Min(value = 0, message = "{Specifications.ram.value.validation.min}")
    @Column(name = "ram")
    private Integer value;

    @Column(name = "memory_type")
    private String type;

    public RAM() { }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
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
        if (!(o instanceof RAM)) return false;

        RAM ram = (RAM) o;

        if (value != null ? !value.equals(ram.value) : ram.value != null) return false;
        return type != null ? type.equals(ram.type) : ram.type == null;

    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return value + ((value > 500) ? " MB" : " GB") +
                ((type == null) ? "" : " " + type);
    }
}
