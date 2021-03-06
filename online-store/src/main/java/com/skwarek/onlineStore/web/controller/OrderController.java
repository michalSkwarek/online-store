package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.data.entity.user.Customer;
import com.skwarek.onlineStore.data.model.order.CartModel;
import com.skwarek.onlineStore.service.AccountService;
import com.skwarek.onlineStore.service.OrderService;
import com.skwarek.onlineStore.service.ProductService;
import com.skwarek.onlineStore.web.CartUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Michal on 18/10/2016.
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    private final static String VIEWS_ORDERS_LIST = "orders/list";
    private final static String VIEWS_CART = "orders/cart";
    private final static String VIEWS_CONFIRM_ORDER = "orders/confirm";
    private final static String VIEWS_ADDRESS_FORM = "addresses/addressData";
    private final static String VIEWS_PRODUCT_UNAVAILABLE = "orders/productUnavailable";
    private final static String VIEWS_THANKS = "orders/thanks";
    private final static String VIEWS_CANCEL = "orders/cancel";
    private final static String REDIRECT_TO = "redirect:";

    private final ProductService productService;
    private final AccountService accountService;
    private final OrderService orderService;

    @Autowired
    public OrderController(ProductService productService, AccountService accountService, OrderService orderService) {
        this.productService = productService;
        this.accountService = accountService;
        this.orderService = orderService;
    }

    @RequestMapping(value = "/{username}/list")
    public String showOrders(@PathVariable String username, Model model) {

        Customer customer = accountService.findAccountByUsername(username).getCustomer();
        List orders = orderService.findCustomerOrders(customer);
        model.addAttribute("orders", orders);
        return VIEWS_ORDERS_LIST;
    }

    @RequestMapping(value = "/addProduct")
    public String addProductToCart(HttpServletRequest request, @RequestParam Long id, Model model) {

        Product product = productService.read(id);
        CartModel cart = CartUtils.getCartModelInSession(request);

        if (!cart.isAddProductToCart(product)) {
            return VIEWS_PRODUCT_UNAVAILABLE;
        }

        orderService.addProductToCart(product, cart);
        model.addAttribute("cart", cart);
        return REDIRECT_TO + "/order/myCart";
    }

    @RequestMapping(value = "/deleteProduct")
    public String deleteProductFromCart(HttpServletRequest request, @RequestParam Long id, Model model) {

        Product product = productService.read(id);
        CartModel cart = CartUtils.getCartModelInSession(request);
        orderService.removeProductFromCart(product, cart);
        model.addAttribute("cart", cart);
        return REDIRECT_TO + "/order/myCart";
    }

    @RequestMapping(value = "/myCart", method = RequestMethod.GET)
    public String showCart(HttpServletRequest request, Model model) {

        CartModel cart = CartUtils.getCartModelInSession(request);
        model.addAttribute("cart", cart);
        return VIEWS_CART;
    }

    @RequestMapping(value = "/myCart", method = RequestMethod.POST)
    public String cartUpdateQuantity(HttpServletRequest request, @RequestParam(value = "quantity") String[] quantities) {

        CartModel cart = CartUtils.getCartModelInSession(request);
        orderService.updateQuantitiesInCart(quantities, cart);
        return REDIRECT_TO + "/order/myCart";
    }

    @RequestMapping(value = "/{username}/address", method = RequestMethod.GET)
    public String initCreateShippingAddressForm(@PathVariable String username, Model model) {

        Address billingAddress = accountService.findAccountByUsername(username).getCustomer().getBillingAddress();
        model.addAttribute("address", billingAddress);
        return VIEWS_ADDRESS_FORM;
    }

    @RequestMapping(value = "/{username}/address", method = RequestMethod.POST)
    public String processCreateShippingAddressForm(@PathVariable String username, HttpServletRequest request, Address address) {

        CartModel cart = CartUtils.getCartModelInSession(request);
        orderService.addShippingAddressToCart(address, cart);
        return REDIRECT_TO + "/order/" + username + "/confirm";
    }

    @RequestMapping(value = "/{username}/confirm", method = RequestMethod.GET)
    public String processConfirmOrder(@PathVariable String username, HttpServletRequest request, Model model) {

        Account account = accountService.findAccountByUsername(username);
        model.addAttribute("account", account);
        CartModel cart = CartUtils.getCartModelInSession(request);
        model.addAttribute("cart", cart);
        Address shippingAddress = cart.getCartAddress();
        model.addAttribute("shippingAddress", shippingAddress);
        return VIEWS_CONFIRM_ORDER;
    }

    @RequestMapping(value = "/{username}/confirm", method = RequestMethod.POST)
    public String processSaveOrder(@PathVariable String username, HttpServletRequest request) {

        CartModel cart = CartUtils.getCartModelInSession(request);
        Customer customer = accountService.findAccountByUsername(username).getCustomer();
        orderService.saveOrder(customer, cart);
        CartUtils.removeCartModelInSession(request);
        return REDIRECT_TO + "/order/" + username + "/thanks";
    }

    @RequestMapping(value = "/{username}/thanks")
    public String thanks(@PathVariable String username, Model model) {

        model.addAttribute("customer", username);
        return VIEWS_THANKS;
    }

    @RequestMapping(value = "/cancel")
    public String cancelOrder(HttpServletRequest request) {

        CartUtils.removeCartModelInSession(request);
        return VIEWS_CANCEL;
    }
}
