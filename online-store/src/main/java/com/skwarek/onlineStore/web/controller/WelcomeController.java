package com.skwarek.onlineStore.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Michal on 27.09.2016.
 */
@Controller
public class WelcomeController {

    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String welcome(Model model) {

        model.addAttribute("welcome", "Welcome to my first app!");
        return "home";
    }
}

