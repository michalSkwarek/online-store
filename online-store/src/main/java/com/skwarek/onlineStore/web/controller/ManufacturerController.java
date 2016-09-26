package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.domain.product.Manufacturer;
import com.skwarek.onlineStore.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Michal on 27.09.2016.
 */
@Controller
@RequestMapping(value = { "/manufacturers" })
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String showProducts(Model model) {

        List<Manufacturer> manufacturers = manufacturerService.getAll();
        model.addAttribute("manufacturers", manufacturers);
        return "manufacturers/list";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String createManufacturer(Model model) {

        model.addAttribute("manufacturer", new Manufacturer());
        return "manufacturers/manufacturerData";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String addManufacturer(Manufacturer manufacturer) {

        manufacturerService.save(manufacturer);
        return "redirect:/manufacturers/list";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
    public String getProduct(@PathVariable Long id, Model model) {

        Manufacturer manufacturer = manufacturerService.getById(id);
        model.addAttribute("manufacturer", manufacturer);
        return "manufacturers/manufacturerData";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
    public String updateProduct(@PathVariable Long id, Manufacturer manufacturer) {

        manufacturerService.save(manufacturer);
        return "redirect:/manufacturers/list";
    }

    @RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
    public String deleteProduct(@PathVariable Long id) {

        Manufacturer toDelete = manufacturerService.getById(id);
        manufacturerService.remove(toDelete);
        return "redirect:/manufacturers/list";
    }
}
