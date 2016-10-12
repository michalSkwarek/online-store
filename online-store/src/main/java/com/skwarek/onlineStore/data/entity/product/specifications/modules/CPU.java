package com.skwarek.onlineStore.data.entity.product.specifications.modules;

import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Michal on 27.09.2016.
 */
@Entity
@Table(name = "cpu")
public class CPU implements Serializable {

    private static final long serialVersionUID = 4093259206949633786L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "number_of_cores")
    private Integer numberOfCores;

    @Column(name = "low_clock_speed")
    private Double lowClockSpeed;

    @Column(name = "high_clock_speed")
    private Double highClockSpeed;

    @Column(name = "cache")
    private Integer cache;

    @OneToMany(mappedBy = "cpu", cascade = CascadeType.ALL)
    private List<ProductSpecifications> specifications;

    public CPU() { }

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

    public Integer getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(Integer numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public Double getLowClockSpeed() {
        return lowClockSpeed;
    }

    public void setLowClockSpeed(Double lowClockSpeed) {
        this.lowClockSpeed = lowClockSpeed;
    }

    public Double getHighClockSpeed() {
        return highClockSpeed;
    }

    public void setHighClockSpeed(Double highClockSpeed) {
        this.highClockSpeed = highClockSpeed;
    }

    public Integer getCache() {
        return cache;
    }

    public void setCache(Integer cache) {
        this.cache = cache;
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
        if (!(o instanceof CPU)) return false;

        CPU cpu = (CPU) o;

        if (id != null ? !id.equals(cpu.id) : cpu.id != null) return false;
        if (model != null ? !model.equals(cpu.model) : cpu.model != null) return false;
        if (numberOfCores != null ? !numberOfCores.equals(cpu.numberOfCores) : cpu.numberOfCores != null) return false;
        if (lowClockSpeed != null ? !lowClockSpeed.equals(cpu.lowClockSpeed) : cpu.lowClockSpeed != null) return false;
        if (highClockSpeed != null ? !highClockSpeed.equals(cpu.highClockSpeed) : cpu.highClockSpeed != null)
            return false;
        return cache != null ? cache.equals(cpu.cache) : cpu.cache == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (numberOfCores != null ? numberOfCores.hashCode() : 0);
        result = 31 * result + (lowClockSpeed != null ? lowClockSpeed.hashCode() : 0);
        result = 31 * result + (highClockSpeed != null ? highClockSpeed.hashCode() : 0);
        result = 31 * result + (cache != null ? cache.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return model + "\n(" + numberOfCores + "-core, " +
                lowClockSpeed + " GHz" +
                ((highClockSpeed == null) ? "" : " - " + highClockSpeed + " GHz") +
                ((cache == null) ? "" : ", " + cache + " MB cache") + ")";
    }
}
