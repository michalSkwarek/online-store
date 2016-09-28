package com.skwarek.onlineStore.domain.product.specifications.modules;

/**
 * Created by Michal on 27.09.2016.
 */
public class Processor {

    private Double speed;
    private String model;
    private Integer RAM;

    public Processor() { }

    public Processor(Double speed, String model, Integer RAM) {
        this.speed = speed;
        this.model = model;
        this.RAM = RAM;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getRAM() {
        return RAM;
    }

    public void setRAM(Integer RAM) {
        this.RAM = RAM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Processor)) return false;

        Processor processor = (Processor) o;

        if (speed != null ? !speed.equals(processor.speed) : processor.speed != null) return false;
        if (model != null ? !model.equals(processor.model) : processor.model != null) return false;
        return RAM != null ? RAM.equals(processor.RAM) : processor.RAM == null;

    }

    @Override
    public int hashCode() {
        int result = speed != null ? speed.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (RAM != null ? RAM.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return speed + "GHz " + model +
                ", with " + RAM + " GB of RAM";
    }
}
