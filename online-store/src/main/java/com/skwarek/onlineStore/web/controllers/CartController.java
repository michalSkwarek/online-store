package com.skwarek.onlineStore.web.controllers;

import com.skwarek.onlineStore.data.entity.order.Cart;
import com.skwarek.onlineStore.data.entity.order.Item;
import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Michal on 18/10/2016.
 */
@Controller
@RequestMapping(value = { "/cart/" })
public class CartController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = { "/buy" }, method = RequestMethod.GET)
    public String getCart(@RequestParam Long id, Model model) {

        Product product = productService.read(id);
        Item item = new Item();
        item.setProduct(product);
        item.setQuantity(1);
        Cart cart = new Cart();
        cart.addItemToCart(item);
        cart.addItemToCart(item);

        Product product2 = productService.read(id+1);
        Item item2 = new Item();
        item2.setProduct(product2);
        item2.setQuantity(1);
        cart.addItemToCart(item2);

        model.addAttribute("cart", cart);
        return "orders/cart";
    }

    @RequestMapping(value = { "/buy" }, method = RequestMethod.POST)
    public String addProductToCart(@RequestParam Item item, Model model) {

        model.addAttribute("item", item);
        return "redirect:/cart/buy";
    }
}
