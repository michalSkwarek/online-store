package com.skwarek.onlineStore.service.impl;

import com.skwarek.onlineStore.data.dao.OrderDao;
import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.data.entity.order.Cart;
import com.skwarek.onlineStore.data.entity.order.Order;
import com.skwarek.onlineStore.data.entity.order.ShippingDetail;
import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.data.entity.user.Customer;
import com.skwarek.onlineStore.data.model.order.CartModel;
import com.skwarek.onlineStore.data.model.order.Item;
import com.skwarek.onlineStore.service.AddressService;
import com.skwarek.onlineStore.service.CustomerService;
import com.skwarek.onlineStore.service.OrderService;
import com.skwarek.onlineStore.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Michal on 20/10/2016.
 */
@Service("orderService")
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl extends GenericServiceImpl<Order, Long> implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @Override
    public void addProductToCart(Product product, CartModel cart) {
        Item item = new Item();
        item.setProduct(product);
        item.setQuantity(1);
        cart.addItemToCart(item);
    }

    @Override
    public void removeProductFromCart(Product product, CartModel cart) {
        cart.removeItemFromCart(product);
    }

    @Override
    public void updateQuantitiesInCart(String[] quantities, CartModel cart) {
        cart.updateQuantity(quantities);
    }

    @Override
    public void setShippingAddressToCart(Address address, CartModel cart) {
        cart.setCartAddress(address);
    }

    @Override
    public void saveOrder(Customer customer, CartModel cart) {
        customer.setNumberOfOrders(customer.getNumberOfOrders() + 1);
        customerService.updateCustomer(customer);

        Cart cartEntity = new Cart();
        cartEntity.setCartTotalPrice(cart.getCartTotalPrice());

        Address billingAddress = customer.getBillingAddress();
        Address shippingAddress = cart.getCartAddress();
        if (billingAddress.equals(shippingAddress)) {
            shippingAddress = billingAddress;
        } else {
            addressService.createShippingAddress(shippingAddress);
        }

        ShippingDetail shippingDetail = new ShippingDetail();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 2);
        shippingDetail.setDateDelivery(calendar.getTime());
        shippingDetail.setShippingAddress(shippingAddress);

        Order order = new Order();
        order.setCart(cartEntity);
        order.setCustomer(customer);
        order.setShippingDetail(shippingDetail);
        order.setDateCreated(new Date());
        orderDao.createOrder(order);
    }
}
