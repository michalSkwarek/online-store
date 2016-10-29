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








    }
}
