package com.skwarek.onlineStore.domain.product.specifications.modules;

import com.skwarek.onlineStore.domain.product.specifications.ProductSpecifications;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Michal on 27.09.2016.
 */
@Entity
@Table(name = "cpu")
public class CPU {

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

    @OneToMany(mappedBy = "cpu", cascade = CascadeType.ALL)
    private List<ProductSpecifications> specifications;

    public CPU() { }

    public CPU(String model) {
        this.model = model;
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
        return model + " (" + numberOfCores + " cores, " +
                formatClockSpeed() + ")";
    }

    private String formatClockSpeed() {
        StringBuilder builder = new StringBuilder();
        builder.append(lowClockSpeed).append(" GHz");
        if (highClockSpeed != null) {
            builder.append(" - ").append(highClockSpeed).append(" GHz");
        }
        return builder.toString();
    }
}
