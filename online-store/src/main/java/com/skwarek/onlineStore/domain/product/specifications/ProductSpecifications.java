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

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "display_id")
//    private Display display;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "battery_id")
//    private Battery battery;
//
//    @Embedded
//    private PowerSupply powerSupply;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "os_id")
//    private OS os;
//
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
}

