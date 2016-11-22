package com.skwarek.onlineStore.data.entity.product.specifications.modules;

import com.skwarek.onlineStore.data.entity.BaseEntity;
import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Michal on 30.09.2016.
 */
@Entity
@Table(name = "gpu")
public class GPU extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -2400380829767762475L;

    @NotEmpty(message = "{Specifications.gpu.model.validation.notEmpty}")
    @Column(name = "model")
    private String model;

    @Min(value = 0, message = "{Specifications.gpu.memory.validation.min}")
    @Column(name = "memory")
    private Integer memory;

    @Column(name = "memory_type")
    private String type;

    @OneToMany(mappedBy = "gpu", cascade = CascadeType.ALL)
    private List<ProductSpecifications> specifications;

    public GPU() { }

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
        this.type = type.equals("") ? null : type;
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
