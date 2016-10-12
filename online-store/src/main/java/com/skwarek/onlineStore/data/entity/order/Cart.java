package com.skwarek.onlineStore.data.entity.order;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Michal on 25.09.2016.
 */
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Item> items;

    @Column(name = "cart_total_price")
    private BigDecimal cartTotalPrice;

    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
    private Order order;

    public Cart() {
        this.items = new LinkedList<>();
        this.cartTotalPrice = new BigDecimal(0);
    }


}
