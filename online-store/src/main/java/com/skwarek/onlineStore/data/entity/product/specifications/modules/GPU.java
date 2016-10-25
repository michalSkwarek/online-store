package com.skwarek.onlineStore.data.entity.product.specifications.modules;

import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Michal on 30.09.2016.
 */
@Entity
@Table(name = "gpu")
public class GPU implements Serializable {

    private static final long serialVersionUID = -2430778721526582057L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "memory")
    private Integer memory;

    @Column(name = "memory_type")
    private String type;

    @OneToMany(mappedBy = "gpu", cascade = CascadeType.ALL)
    private List<ProductSpecifications> specifications;

    public GPU() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = (type.equals("") ? null : type);
    }

    public List<ProductSpecifications> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<ProductSpecifications> specifications) {
        this.specifications = specifications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GPU)) return false;

        GPU gpu = (GPU) o;

        if (model != null ? !model.equals(gpu.model) : gpu.model != null) return false;
        if (memory != null ? !memory.equals(gpu.memory) : gpu.memory != null) return false;
        return type != null ? type.equals(gpu.type) : gpu.type == null;

    }

    @Override
    public int hashCode() {
        int result = model != null ? model.hashCode() : 0;
        result = 31 * result + (memory != null ? memory.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return model +
                ((memory == null) ? "" : " " + memory + " GB") +
                ((type == null) ? "" : " " + type);
    }
}
