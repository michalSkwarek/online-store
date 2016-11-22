package com.skwarek.onlineStore.data.entity.product.specifications.modules;

import com.skwarek.onlineStore.data.entity.BaseEntity;
import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Michal on 27.09.2016.
 */
@Entity
@Table(name = "cpu")
public class CPU extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 464847117784533352L;

    @NotEmpty(message = "{Specifications.cpu.model.validation.notEmpty}")
    @Column(name = "model")
    private String model;

    @NotNull(message = "{Specifications.cpu.numberOfCores.validation.notNull}")
    @Min(value = 0, message = "{Specifications.cpu.numberOfCores.validation.min}")
    @Column(name = "number_of_cores")
    private Integer numberOfCores;

    @NotNull(message = "{Specifications.cpu.lowClockSpeed.validation.notNull}")
    @Min(value = 0, message = "{Specifications.cpu.lowClockSpeed.validation.min}")
    @Digits(integer = 8, fraction = 2, message = "{Specifications.cpu.lowClockSpeed.validation.digits}")
    @Column(name = "low_clock_speed")
    private Double lowClockSpeed;

    @Min(value = 0, message = "{Specifications.cpu.highClockSpeed.validation.min}")
    @Digits(integer = 8, fraction = 2, message = "{Specifications.cpu.highClockSpeed.validation.digits}")
    @Column(name = "high_clock_speed")
    private Double highClockSpeed;

    @OneToMany(mappedBy = "cpu", cascade = CascadeType.ALL)
    private List<ProductSpecifications> specifications;

    public CPU() { }

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

        if (model != null ? !model.equals(cpu.model) : cpu.model != null) return false;
        if (numberOfCores != null ? !numberOfCores.equals(cpu.numberOfCores) : cpu.numberOfCores != null) return false;
        if (lowClockSpeed != null ? !lowClockSpeed.equals(cpu.lowClockSpeed) : cpu.lowClockSpeed != null) return false;
        return highClockSpeed != null ? highClockSpeed.equals(cpu.highClockSpeed) : cpu.highClockSpeed == null;

    }

    @Override
    public int hashCode() {
        int result = model != null ? model.hashCode() : 0;
        result = 31 * result + (numberOfCores != null ? numberOfCores.hashCode() : 0);
        result = 31 * result + (lowClockSpeed != null ? lowClockSpeed.hashCode() : 0);
        result = 31 * result + (highClockSpeed != null ? highClockSpeed.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return model + " (" + numberOfCores + "-core, " +
                lowClockSpeed + " GHz" +
                ((highClockSpeed == null) ? "" : " - " + highClockSpeed + " GHz") + ")";
    }
}
