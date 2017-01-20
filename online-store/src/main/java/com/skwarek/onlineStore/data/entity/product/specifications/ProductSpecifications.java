package com.skwarek.onlineStore.data.entity.product.specifications;

import com.skwarek.onlineStore.data.entity.BaseEntity;
import com.skwarek.onlineStore.data.entity.product.specifications.modules.*;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;

/**
 * Created by Michal on 27.09.2016.
 */
@Entity
@Table(name = "specifications")
public class ProductSpecifications extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 2338356791547882364L;

    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cpu_id")
    private CPU cpu;

    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gpu_id")
    private GPU gpu;

    @Valid
    @Embedded
    private RAM ram;

    @Valid
    @Embedded
    private Storage storage;

    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "display_id")
    private Display display;

    @Valid
    @Embedded
    private Battery battery;

    @Valid
    @Embedded
    private PowerSupply powerSupply;

    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "os_id")
    private OS os;

    @Valid
    @Embedded
    private Camera camera;

    @Valid
    @Embedded
    private Webcam webcam;

    @Valid
    @Embedded
    private Dimensions dimensions;

    @Valid
    @Embedded
    private Weight weight;

    public ProductSpecifications() { }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public PowerSupply getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Webcam getWebcam() {
        return webcam;
    }

    public void setWebcam(Webcam webcam) {
        this.webcam = webcam;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductSpecifications)) return false;

        ProductSpecifications that = (ProductSpecifications) o;

        if (cpu != null ? !cpu.equals(that.cpu) : that.cpu != null) return false;
        if (gpu != null ? !gpu.equals(that.gpu) : that.gpu != null) return false;
        if (ram != null ? !ram.equals(that.ram) : that.ram != null) return false;
        if (storage != null ? !storage.equals(that.storage) : that.storage != null) return false;
        if (display != null ? !display.equals(that.display) : that.display != null) return false;
        if (battery != null ? !battery.equals(that.battery) : that.battery != null) return false;
        if (powerSupply != null ? !powerSupply.equals(that.powerSupply) : that.powerSupply != null) return false;
        if (os != null ? !os.equals(that.os) : that.os != null) return false;
        if (camera != null ? !camera.equals(that.camera) : that.camera != null) return false;
        if (webcam != null ? !webcam.equals(that.webcam) : that.webcam != null) return false;
        if (dimensions != null ? !dimensions.equals(that.dimensions) : that.dimensions != null) return false;
        return weight != null ? weight.equals(that.weight) : that.weight == null;

    }

    @Override
    public int hashCode() {
        int result = cpu != null ? cpu.hashCode() : 0;
        result = 31 * result + (gpu != null ? gpu.hashCode() : 0);
        result = 31 * result + (ram != null ? ram.hashCode() : 0);
        result = 31 * result + (storage != null ? storage.hashCode() : 0);
        result = 31 * result + (display != null ? display.hashCode() : 0);
        result = 31 * result + (battery != null ? battery.hashCode() : 0);
        result = 31 * result + (powerSupply != null ? powerSupply.hashCode() : 0);
        result = 31 * result + (os != null ? os.hashCode() : 0);
        result = 31 * result + (camera != null ? camera.hashCode() : 0);
        result = 31 * result + (webcam != null ? webcam.hashCode() : 0);
        result = 31 * result + (dimensions != null ? dimensions.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProductSpecifications{" +
                ((cpu == null) ? "" : ", cpu=" + cpu) +
                ((gpu == null) ? "" : ", gpu=" + gpu) +
                ((ram == null) ? "" : ", ram=" + ram) +
                ((storage == null) ? "" : ", storage=" + storage) +
                ((display == null) ? "" : ", display=" + display) +
                ((battery == null) ? "" : ", battery=" + battery) +
                ((powerSupply == null) ? "" : ", powerSupply=" + powerSupply) +
                ((os == null) ? "" : ", os=" + os) +
                ((camera == null) ? "" : ", camera=" + camera) +
                ((webcam == null) ? "" : ", webcam=" + webcam) +
                ((dimensions == null) ? "" : ", dimensions=" + dimensions) +
                ((weight == null) ? "" : ", weight=" + weight) +
                "}";
    }
}

