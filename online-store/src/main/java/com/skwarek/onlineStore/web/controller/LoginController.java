package com.skwarek.onlineStore.web.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Michal on 04.10.2016.
 */
@Controller
public class LoginController {

    private static final String VIEWS_LOGIN_FORM = "security/login";
    private static final String VIEWS_HELLO = "security/hello";
    private static final String VIEWS_ACCESS_DENIED = "security/accessDenied";

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String initLoginForm(Model model,
                        @RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout) {

        if (error != null) {
            model.addAttribute("error", true);
        }

        if (logout != null) {
            model.addAttribute("message", true);
        }

        return VIEWS_LOGIN_FORM;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloPage() {

        return VIEWS_HELLO;
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public String accessDenied(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addAttribute("username", userDetail.getUsername());
        }

        return VIEWS_ACCESS_DENIED;
    }
}

