package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.data.entity.user.Customer;
import com.skwarek.onlineStore.data.model.order.CartModel;
import com.skwarek.onlineStore.service.*;
import com.skwarek.onlineStore.web.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Michal on 18/10/2016.
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private ProductService productService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/addProduct")
    public String addProductToCart(HttpServletRequest request, @RequestParam Long id, Model model) {

        Product product = productService.read(id);
        CartModel cart = Utils.getCartModelInSession(request);
        orderService.addProductToCart(product, cart);
        model.addAttribute("cart", cart);
        return "redirect:/order/myCart";
    }

    @RequestMapping(value = "/deleteProduct")
    public String deleteProductFromCart(HttpServletRequest request, @RequestParam Long id, Model model) {

        Product product = productService.read(id);
        CartModel cart = Utils.getCartModelInSession(request);
        orderService.removeProductFromCart(product, cart);
        model.addAttribute("cart", cart);
        return "redirect:/order/myCart";
    }

    @RequestMapping(value = "/myCart", method = RequestMethod.GET)
    public String getCart(HttpServletRequest request, Model model) {

        CartModel cart = Utils.getCartModelInSession(request);
        model.addAttribute("cart", cart);
        return "orders/cart";
    }

    @RequestMapping(value = "/myCart", method = RequestMethod.POST)
    public String cartUpdateQuantity(HttpServletRequest request, @RequestParam(value = "quantity") String[] quantities) {

        CartModel cart = Utils.getCartModelInSession(request);
        orderService.updateQuantitiesInCart(quantities, cart);
        return "redirect:/order/myCart";
    }

    @RequestMapping(value = "/{username}/address", method = RequestMethod.GET)
    public String getAddress(@PathVariable String username, Model model) {

        Address billingAddress = accountService.getAccountByUsername(username).getCustomer().getBillingAddress();
        model.addAttribute("address", billingAddress);
        return "addresses/addressData";
    }

    @RequestMapping(value = "/{username}/address", method = RequestMethod.POST)
    public String confirmShippingAddress(@PathVariable String username, HttpServletRequest request, Address address) {

        CartModel cart = Utils.getCartModelInSession(request);
        orderService.setShippingAddressToCart(address, cart);
        return "redirect:/order/" + username + "/confirm";
    }

    @RequestMapping(value = "/{username}/confirm", method = RequestMethod.GET)
    public String confirmOrder(@PathVariable String username, HttpServletRequest request, Model model) {

        Account account = accountService.getAccountByUsername(username);
        model.addAttribute("account", account);
        CartModel cart = Utils.getCartModelInSession(request);
        model.addAttribute("cart", cart);
        Address shippingAddress = cart.getCartAddress();
        model.addAttribute("shippingAddress", shippingAddress);
        return "orders/confirm";
    }

    @RequestMapping(value = "/{username}/confirm", method = RequestMethod.POST)
    public String saveOrder(@PathVariable String username, HttpServletRequest request) {

        CartModel cart = Utils.getCartModelInSession(request);
        Customer customer = accountService.getAccountByUsername(username).getCustomer();
        orderService.saveOrder(customer, cart);
        Utils.removeCartModelInSession(request);
        return "redirect:/order/" + username + "/thanks";
    }

    @RequestMapping(value = { "/{username}/thanks" })
    public String thanks(@PathVariable String username, Model model) {

        model.addAttribute("customer", username);
        return "orders/thanks";
    }

    @RequestMapping(value = { "/cancel" })
    public String cancelOrder(HttpServletRequest request) {

        Utils.removeCartModelInSession(request);
        return "orders/cancel";
    }
}
