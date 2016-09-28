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
    @JoinColumn(name = "display_id")
    private Display display;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "battery_id")
    private Battery battery;

    @Embedded
    private PowerSupply powerSupply;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "os_id")
    private OS os;

    @Embedded
    private Weight weight;

    @OneToOne(mappedBy = "productSpecifications", cascade = CascadeType.ALL)
    private Product product;

    public ProductSpecifications() { }

    public ProductSpecifications(Display display, Battery battery, PowerSupply powerSupply, OS os, Weight weight) {
        this.display = display;
        this.battery = battery;
        this.powerSupply = powerSupply;
        this.os = os;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "\nProductSpecifications{" +
                "\n, display=" + display +
                "\n, battery=" + battery +
                "\n, powerSupply=" + powerSupply +
                "\n, os=" + os +
                "\n, weight=" + weight +
                '}';
    }
}

