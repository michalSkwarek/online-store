package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.data.entity.user.Customer;
import com.skwarek.onlineStore.service.AddressService;
import com.skwarek.onlineStore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Michal on 23.09.2016.
 */
@Controller
@RequestMapping(value = { "/addresses" })
public class AddressController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @RequestMapping("/{username}")
    public String getAddressByUsername(@PathVariable String username, Model model) {

        Address address = addressService.getAddressByUsername(username);
        model.addAttribute("address", address);
        return "addresses/addressData";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String createAddress(Model model) {

        model.addAttribute("address", new Address());
        return "addresses/addressData";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String addAddress(Address address) {

        Customer customer = customerService.getLastCustomer();
        addressService.createAddress(address);
        customer.setBillingAddress(address);
        customerService.update(customer);
        return "redirect:/welcome";
    }

    @RequestMapping(value = { "/edit/{username}" }, method = RequestMethod.GET)
    public String getAddress(@PathVariable String username, Model model) {

        Address address = addressService.getAddressByUsername(username);
        model.addAttribute("address", address);
        return "addresses/addressData";
    }

    @RequestMapping(value = { "/edit/{username}" }, method = RequestMethod.POST)
    public String updateAddress(@PathVariable String username, Address address) {

        Address oldAddress = addressService.getAddressByUsername(username);
        address.setId(oldAddress.getId());
        addressService.updateAddress(address);
        return "redirect:/users/" + username;
    }
}