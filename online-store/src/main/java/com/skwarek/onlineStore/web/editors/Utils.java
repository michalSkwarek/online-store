package com.skwarek.onlineStore.web.editors;

import com.skwarek.onlineStore.data.entity.order.Cart;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Michal on 18/10/2016.
 */
public class Utils {

    public static Cart getCartInSession(HttpServletRequest request) {

        Cart cart = (Cart) request.getSession().getAttribute("myCart");

        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("myCart", cart);
        }
        return cart;
    }

    public static void removeCartInSession(HttpServletRequest request) {
        request.getSession().removeAttribute("myCart");
    }

    public static void storeLastOrderedCartInSession(HttpServletRequest request, Cart cart) {
        request.getSession().setAttribute("lastOrderedCart", cart);
    }

    public static Cart getLastOrderedCartInSession(HttpServletRequest request) {
        return (Cart) request.getSession().getAttribute("lastOrderedCart");
    }

}
