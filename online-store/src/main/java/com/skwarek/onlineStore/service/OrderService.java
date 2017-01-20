package com.skwarek.onlineStore.service;

import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.data.entity.order.Order;
import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.data.entity.user.Customer;
import com.skwarek.onlineStore.data.model.order.CartModel;
import com.skwarek.onlineStore.service.generic.GenericService;

import java.util.List;

/**
 * Created by Michal on 20/10/2016.
 */
public interface OrderService extends GenericService<Order, Long> {

    List findCustomerOrders(Customer customer);

    void addProductToCart(Product product, CartModel cart);

    void removeProductFromCart(Product product, CartModel cart);

    void updateQuantitiesInCart(String[] quantities, CartModel cart);

    void addShippingAddressToCart(Address address, CartModel cart);

    void saveOrder(Customer customer, CartModel cart);
}