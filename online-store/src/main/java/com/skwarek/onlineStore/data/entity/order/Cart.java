//package com.skwarek.onlineStore.data.entity.order;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
///**
// * Created by Michal on 25.09.2016.
// */
//@Entity
//@Table(name = "cart")
//public class Cart {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
//    private Map<Long, Item> items;
//
//    @Column(name = "cart_total_price")
//    private BigDecimal cartTotalPrice;
//
//    public Cart() {
//        this.items = new HashMap<>();
//        cartTotalPrice = new BigDecimal(0);
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Map<Long, Item> getItems() {
//        return items;
//    }
//
//    public void setItems(Map<Long, Item> items) {
//        this.items = items;
//    }
//
//    public BigDecimal getCartTotalPrice() {
//        return cartTotalPrice;
//    }
//
//    public void setCartTotalPrice(BigDecimal cartTotalPrice) {
//        this.cartTotalPrice = cartTotalPrice;
//    }
//
//    public void addItem(Item item) {
//        Long id = item.getProduct().getId();
//        if (items.containsKey(id)) {
//            Item existingItem = items.get(id);
//            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
//            items.put(id, existingItem);
//        } else {
//            items.put(id, item);
//        }
//        updateCartTotalPrice();
//    }
//
//    public void removeItem(Item item) {
//        Long id = item.getProduct().getId();
//        items.remove(id);
//        updateCartTotalPrice();
//    }
//
//    public void updateCartTotalPrice() {
//        cartTotalPrice = new BigDecimal(0);
//        for (Item item : items.values()) {
//            cartTotalPrice = cartTotalPrice.add(item.getItemTotalPrice());
//        }
//    }
//}
