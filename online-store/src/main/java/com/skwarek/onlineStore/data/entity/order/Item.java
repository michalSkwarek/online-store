package com.skwarek.onlineStore.data.entity.order;

import com.skwarek.onlineStore.data.entity.product.Product;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Michal on 25.09.2016.
 */
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "item_total_price")
    private BigDecimal itemTotalPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public Item() { }


}
