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

    private final static String VIEWS_CUSTOMER_FORM = "customers/customerData";
    private final static String REDIRECT_TO = "redirect:";

    private final AccountService accountService;
    private final CustomerService customerService;

    @Autowired
    public CustomerController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String initCreateCustomerForm(Model model) {

        model.addAttribute("customer", new Customer());
        return VIEWS_CUSTOMER_FORM;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String processCreateCustomerForm(@Valid Customer customer, BindingResult result) {

        if (result.hasErrors()) {
            return VIEWS_CUSTOMER_FORM;
        }

        customerService.createCustomer(customer);
        return REDIRECT_TO + "/addresses/new";
    }

    @RequestMapping(value = "/edit/{username}", method = RequestMethod.GET)
    public String initUpdateCustomerForm(@PathVariable String username, Model model) {

        Customer customer = accountService.findAccountByUsername(username).getCustomer();
        model.addAttribute("customer", customer);
        return VIEWS_CUSTOMER_FORM;
    }

    @RequestMapping(value = "/edit/{username}", method = RequestMethod.POST)
    public String processUpdateCustomerForm(@PathVariable String username, @Valid Customer customer, BindingResult result) {

        if (result.hasErrors()) {
            return VIEWS_CUSTOMER_FORM;
        }

        customerService.updateCustomer(customer);
        return REDIRECT_TO + "/users/" + username;
    }
}
