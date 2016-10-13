package com.skwarek.onlineStore.web.controllers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Michal on 04.10.2016.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model,
                        @RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout) {
        if (error != null) {
            model.addAttribute("error", "Invalid username and password!");
        }
        if (logout != null) {
            model.addAttribute("msg", "You've been logged out successfully.");
        }
        return "/security/login";
    }

    @RequestMapping(value = { "/hello" }, method = RequestMethod.GET)
    public String defaultPage(Model model) {

        model.addAttribute("title", "Spring Security Login Form - Database Authentication");
        model.addAttribute("message", "This is default page!");
        return "/security/hello";
    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public String adminPage(Model model) {

        model.addAttribute("title", "Spring Security Login Form - Database Authentication");
        model.addAttribute("message", "This page is for ROLE_ADMIN only!");
        return "/security/admin";

    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            System.out.println(userDetail);

            model.addAttribute("username", userDetail.getUsername());
        }
        return "/security/403";
    }
}

