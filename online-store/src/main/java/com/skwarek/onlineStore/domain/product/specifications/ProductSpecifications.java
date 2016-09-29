package com.skwarek.onlineStore.domain.product.specifications;

import com.skwarek.onlineStore.domain.product.Product;
import com.skwarek.onlineStore.domain.product.specifications.modules.*;

import javax.persistence.*;

/**
 * Created by Michal on 27.09.2016.
 */
@Entity
@Table(name = "specifications")
public class ProductSpecifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cpu_id")
    private CPU cpu;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gpu_id")
    private GPU gpu;

    @Embedded
    private RAM ram;

    @Embedded
    private Disk disk;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "display_id")
    private Display display;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "battery_id")
    private Battery battery;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "os_id")
    private OS os;

//    @Embedded
//    private PowerSupply powerSupply;

//    @Embedded
//    private Weight weight;

    @OneToOne(mappedBy = "productSpecifications", cascade = CascadeType.ALL)
    private Product product;

    public ProductSpecifications() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
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

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }
}

