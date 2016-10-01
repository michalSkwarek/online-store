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
    @JoinColumn(name = "memory_type_id")
    private MemoryType memoryType;

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

    public MemoryType getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(MemoryType memoryType) {
        this.memoryType = memoryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RAM)) return false;

        RAM ram = (RAM) o;

        if (value != null ? !value.equals(ram.value) : ram.value != null) return false;
        return memoryType != null ? memoryType.equals(ram.memoryType) : ram.memoryType == null;

    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (memoryType != null ? memoryType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return value + ((value > 500) ? " MB" : " GB") +
                ((memoryType == null) ? "" : " " + memoryType);
    }
}
