package com.skwarek.onlineStore.web.controllers;

import com.skwarek.onlineStore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Michal on 13/10/16.
 */
@Controller
@RequestMapping(value = { "/customers" })
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/{username}")
    public String getProductById(Model model, @PathVariable String username) {
        model.addAttribute("customer", customerService.getCustomerByUsername(username));
        return "customers/customerData";
    }
}
