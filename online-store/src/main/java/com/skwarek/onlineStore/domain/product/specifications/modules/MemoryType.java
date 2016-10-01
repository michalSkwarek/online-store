package com.skwarek.onlineStore.domain.product.specifications.modules;

import javax.persistence.*;

/**
 * Created by Michal on 01.10.2016.
 */
@Entity
@Table(name = "memory_type")
public class MemoryType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    public MemoryType() { }

    public MemoryType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(o instanceof MemoryType)) return false;

        MemoryType ramType = (MemoryType) o;

        if (id != null ? !id.equals(ramType.id) : ramType.id != null) return false;
        return type != null ? type.equals(ramType.type) : ramType.type == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return type;
    }
}

