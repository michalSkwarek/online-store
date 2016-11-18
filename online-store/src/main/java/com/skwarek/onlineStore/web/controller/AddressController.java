package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.service.AccountService;
import com.skwarek.onlineStore.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Michal on 23.09.2016.
 */
@Controller
@RequestMapping(value = "/addresses")
public class AddressController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String createAddress(Model model) {

        model.addAttribute("address", new Address());
        return "addresses/addressData";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addAddress(@Valid Address address, BindingResult result) {

        if (result.hasErrors()) {
            return "addresses/addressData";
        }

        addressService.createBillingAddress(address);
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/edit/{username}", method = RequestMethod.GET)
    public String getAddress(@PathVariable String username, Model model) {

        Address address = accountService.findAccountByUsername(username).getCustomer().getBillingAddress();
        model.addAttribute("address", address);
        return "addresses/addressData";
    }

    @RequestMapping(value = "/edit/{username}", method = RequestMethod.POST)
    public String updateAddress(@PathVariable String username, @Valid Address address, BindingResult result) {

        if (result.hasErrors()) {
            return "addresses/addressData";
        }

        addressService.updateBillingAddress(address);
        return "redirect:/users/" + username;
    }
}
