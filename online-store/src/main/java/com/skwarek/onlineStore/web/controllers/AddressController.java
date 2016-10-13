package com.skwarek.onlineStore.web.controllers;

import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Michal on 23.09.2016.
 */
@Controller
@RequestMapping(value = { "/addresses" })
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping("/{username}")
    public String getProductById(Model model, @PathVariable String username) {
        model.addAttribute("address", addressService.getAddressByUsername(username));
        return "addresses/addressData";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String createAddress(Model model) {

        model.addAttribute("address", new Address());
        return "addresses/addressData";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String addAddress(Address address) {

        addressService.createAddress(address);
        return "redirect:/";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
    public String getAddress(@PathVariable Long id, Model model) {

        Address address = addressService.read(id);
        model.addAttribute("address", address);
        return "addresses/addressData";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
    public String updateAddress(@PathVariable Long id, Address address) {

        addressService.updateAddress(address);
        return "redirect:/";
    }

    @RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
    public String deleteAddress(@PathVariable Long id) {

        addressService.deleteAddress(id);
        return "redirect:/";
    }
}
