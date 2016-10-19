package com.skwarek.onlineStore.web.controllers;

import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.data.entity.order.Cart;
import com.skwarek.onlineStore.data.entity.order.Item;
import com.skwarek.onlineStore.data.entity.order.ShippingDetail;
import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.service.AccountService;
import com.skwarek.onlineStore.service.AddressService;
import com.skwarek.onlineStore.service.ProductService;
import com.skwarek.onlineStore.web.editors.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Michal on 18/10/2016.
 */
@Controller
@RequestMapping(value = { "/cart/" })
public class CartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = { "/buy" })
    public String buyProduct(HttpServletRequest request, @RequestParam Long id, Model model) {

        Product product = productService.read(id);
        Cart cart = Utils.getCartInSession(request);
        Item item = new Item();
        item.setProduct(product);
        item.setQuantity(1);
        cart.addItemToCart(item);

        model.addAttribute("cart", cart);
        return "redirect:/cart/myCart";
    }

    @RequestMapping(value = { "/deleteProduct" })
    public String deleteProductFromCart(HttpServletRequest request, @RequestParam Long id, Model model) {

        Product product = productService.read(id);
        Cart cart = Utils.getCartInSession(request);
        cart.removeItemFromCart(product);

        model.addAttribute("cart", cart);
        return "redirect:/cart/myCart";
    }

    @RequestMapping(value = { "/myCart" }, method = RequestMethod.GET)
    public String getCart(HttpServletRequest request, Model model) {

        Cart cart = Utils.getCartInSession(request);
        model.addAttribute("cart", cart);
        return "orders/cart";
    }

    @RequestMapping(value = { "/myCart" }, method = RequestMethod.POST)
    public String cartUpdateQuantity(HttpServletRequest request, Cart cart) {

        System.out.println(" dupa1 " + cart);
        Cart cartInfo = Utils.getCartInSession(request);
        System.out.println(" dupa2 " + cartInfo);
        cartInfo = cart;

        // Redirect to shoppingCart page.
        return "redirect:/cart/myCart";
    }

    @RequestMapping(value = { "/address/{username}" }, method = RequestMethod.GET)
    public String getAddress(@PathVariable String username, HttpServletRequest request, Cart cart, Model model) {

        Address billingAddress = accountService.getAccountByUsername(username).getCustomer().getBillingAddress();
        model.addAttribute("address", billingAddress);
        return "addresses/addressData";
    }

    @RequestMapping(value = { "/address/{username}" }, method = RequestMethod.POST)
    public String confirmShippingAddress(@PathVariable String username, Address address) {

        Address shippingAddress = address;
        return "redirect:/cart/confirm";
    }

    @RequestMapping(value = { "/{username}/confirm" }, method = RequestMethod.GET)
    public String confirmOrder(@PathVariable String username, HttpServletRequest request, Model model) {

        Account account = accountService.getAccountByUsername(username);
        model.addAttribute("account", account);
        Cart cart = Utils.getCartInSession(request);
        model.addAttribute("cart", cart);
//        Address shippingAddress = addressService.getAddressByUsername(username);
//        model.addAttribute("address", shippingAddress);
        return "orders/" + username + "/confirm";
    }

    @RequestMapping(value = { "/{username}/confirm" }, method = RequestMethod.POST)
    public String saveOrder(@PathVariable String username, HttpServletRequest request, Cart cart, Address shippingAddress) {

//        CartService.save(cart);
//        ShippingDetailService
//        Address shippingAddress = addressService.getAddressByUsername(username);
//        model.addAttribute("address", shippingAddress);
        return "orders/confirm";
    }

    @RequestMapping(value = { "/{username}/confirm/cancel" })
    public String cancelOrder(@PathVariable String username, HttpServletRequest request, Model model) {

        Account account = accountService.getAccountByUsername(username);
        model.addAttribute("account", account);
        Cart cart = Utils.getCartInSession(request);
        model.addAttribute("cart", cart);
//        Address shippingAddress = addressService.getAddressByUsername(username);
//        model.addAttribute("address", shippingAddress);
        return "orders/confirm";
    }
}
