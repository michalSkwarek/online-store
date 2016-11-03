package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.data.entity.user.Customer;
import com.skwarek.onlineStore.service.AccountService;
import com.skwarek.onlineStore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Michal on 13/10/16.
 */
@Controller
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/{username}")
    public String getCustomerByUsername(@PathVariable String username, Model model) {

        Customer customer = accountService.getAccountByUsername(username).getCustomer();
        model.addAttribute("customer", customer);
        return "customers/customerData";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String createCustomer(Model model) {

        model.addAttribute("customer", new Customer());
        return "customers/customerData";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addCustomer(@Valid Customer customer, BindingResult result) {

        if (result.hasErrors()) {
            return "customers/customerData";
        }

        customerService.createCustomer(customer);
        return "redirect:/addresses/new";
    }

    @RequestMapping(value = "/edit/{username}", method = RequestMethod.GET)
    public String getAddress(@PathVariable String username, Model model) {

        Customer customer = accountService.getAccountByUsername(username).getCustomer();
        model.addAttribute("customer", customer);
        return "customers/customerData";
    }

    @RequestMapping(value = "/edit/{username}", method = RequestMethod.POST)
    public String updateAddress(@PathVariable String username, @Valid Customer customer, BindingResult result) {

        if (result.hasErrors()) {
            return "customers/customerData";
        }

        customerService.updateCustomer(customer);
        return "redirect:/users/" + username;
    }
}
