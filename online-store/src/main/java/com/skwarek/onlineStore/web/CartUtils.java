package com.skwarek.onlineStore.web;

import com.skwarek.onlineStore.data.model.order.CartModel;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Michal on 18/10/2016.
 */
public class CartUtils {

    public static CartModel getCartModelInSession(HttpServletRequest request) {
        CartModel cartModel = (CartModel) request.getSession().getAttribute("cart");
        if (cartModel == null) {
            cartModel = new CartModel();
            request.getSession().setAttribute("cart", cartModel);
        }
        return cartModel;
    }

    public static void removeCartModelInSession(HttpServletRequest request) {
        request.getSession().removeAttribute("cart");
    }
}
