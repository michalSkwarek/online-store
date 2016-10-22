package com.skwarek.onlineStore.domain;

import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.data.entity.address.City;
import com.skwarek.onlineStore.data.entity.order.Cart;
import com.skwarek.onlineStore.data.entity.order.Order;
import com.skwarek.onlineStore.data.entity.order.ShippingDetail;
import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.data.model.order.CartModel;
import com.skwarek.onlineStore.data.model.order.Item;
import com.skwarek.onlineStore.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

/**
 * Created by Michal on 26.09.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/test/resources/test-DispatcherServlet-context.xml"})
@WebAppConfiguration
public class HelloWorld {

    @Autowired
    private ProductService productService;

    @Test
    public void myTest() {
        Product product = productService.read(1L);
        System.out.println(" dupa1 ");

        Item item = new Item();
        item.setProduct(product);
        item.setQuantity(1);
        System.out.println(" === " + item);
        System.out.println(" === " + item.getQuantity());
        System.out.println(" === " + item.getItemTotalPrice());
//        item.setQuantity(3);
//        System.out.println(" === ");
//        System.out.println(" === " + item.getQuantity());
//        System.out.println(" === " + item.getItemTotalPrice());

        CartModel cart = new CartModel();
        cart.addItemToCart(item);
        System.out.println(" === " + cart.getCartTotalPrice());

        Product product2 = productService.read(2L);
        Item item2 = new Item();
        item2.setProduct(product2);
        item2.setQuantity(2);
        cart.addItemToCart(item2);
        System.out.println(" === " + cart.getCartTotalPrice());

        System.out.println(" === " + cart);

        System.out.println(" === " + cart);

        Address address = new Address();
        address.setStreet("Gorzno Kolonia");
        address.setDoorNumber("14B");
        address.setZipCode("08-404");
        City city = new City();
        city.setName("Gorzno");
        address.setCity(city);
        System.out.println(address);

        ShippingDetail shippingDetails = new ShippingDetail();
        shippingDetails.setDateDelivery(new Date(2000, 0, 1));
        shippingDetails.setShippingAddress(address);
        System.out.println(shippingDetails);

        Order order = new Order();
//        order.setCart(cart);
        order.setShippingDetail(shippingDetails);
        System.out.println(order);






    }
}
