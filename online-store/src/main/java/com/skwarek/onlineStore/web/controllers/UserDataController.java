package com.skwarek.onlineStore.web.controllers;

import com.skwarek.onlineStore.service.AccountService;
import com.skwarek.onlineStore.service.AddressService;
import com.skwarek.onlineStore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Michal on 14/10/16.
 */
@Controller
@RequestMapping(value = { "/users" })
public class UserDataController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @RequestMapping("/{username}")
    public String getUserData(Model model, @PathVariable String username) {

        model.addAttribute("account", accountService.getAccountByUsername(username));
        model.addAttribute("customer", customerService.getCustomerByUsername(username));
        model.addAttribute("address", addressService.getAddressByUsername(username));
        return "users/userData";
    }
}
