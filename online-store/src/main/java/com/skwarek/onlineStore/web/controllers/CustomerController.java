package com.skwarek.onlineStore.web.controllers;

import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.data.entity.user.Customer;
import com.skwarek.onlineStore.service.AccountService;
import com.skwarek.onlineStore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Michal on 13/10/16.
 */
@Controller
@RequestMapping(value = { "/customers" })
public class CustomerController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/{username}")
    public String getProductById(Model model, @PathVariable String username) {
        model.addAttribute("customer", customerService.getCustomerByUsername(username));
        return "customers/customerData";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String createCustomer(Model model) {

        model.addAttribute("customer", new Customer());
        return "customers/customerData";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String addCustomer(Customer customer) {

        customer.setNumberOfOrders(0);
        Account account = accountService.getLastAccount();
        account.setCustomer(customer);
        accountService.update(account);
        return "redirect:/addresses/new";
    }

//    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
//    public String getAddress(@PathVariable Long id, Model model) {
//
//        Address address = addressService.read(id);
//        model.addAttribute("address", address);
//        List countries = addressService.getAllCountries();
//        model.addAttribute("countries", countries);
//        return "addresses/addressData";
//    }
//
//    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
//    public String updateAddress(@PathVariable Long id, Address address) {
//
//        String username = addressService.read(id).getCustomer().getAccount().getUsername();
//        addressService.updateAddress(address);
//        return "redirect:/users/" + username;
//    }
}
