package com.skwarek.onlineStore.domain.product.specifications.modules;

import com.skwarek.onlineStore.domain.product.specifications.ProductSpecifications;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Michal on 30.09.2016.
 */
@Entity
@Table(name = "gpu")
public class GPU {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "model")
    private String model;

    @OneToMany(mappedBy = "gpu", cascade = CascadeType.ALL)
    private List<ProductSpecifications> specifications;

    public GPU() { }

    public GPU(String model) {
        this.model = model;
    }

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

        if (id != null ? !id.equals(gpu.id) : gpu.id != null) return false;
        if (model != null ? !model.equals(gpu.model) : gpu.model != null) return false;
        return specifications != null ? specifications.equals(gpu.specifications) : gpu.specifications == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (specifications != null ? specifications.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return model;
    }
}
