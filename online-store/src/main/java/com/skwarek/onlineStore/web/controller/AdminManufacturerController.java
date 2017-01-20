package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.data.entity.product.Manufacturer;
import com.skwarek.onlineStore.service.ManufacturerService;
import com.skwarek.onlineStore.web.validator.BrandValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Michal on 27.09.2016.
 */
@Controller
@RequestMapping(value = "/admin/manufacturers")
public class AdminManufacturerController {

    private final static String VIEWS_MANUFACTURERS_LIST = "manufacturers/list";
    private final static String VIEWS_MANUFACTURER_FORM = "manufacturers/manufacturerData";
    private final static String REDIRECT_TO = "redirect:";

    private final ManufacturerService manufacturerService;
    private final BrandValidator brandValidator;

    @Autowired
    public AdminManufacturerController(ManufacturerService manufacturerService, BrandValidator brandValidator) {
        this.manufacturerService = manufacturerService;
        this.brandValidator = brandValidator;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showManufacturers(Model model) {

        List<Manufacturer> manufacturers = manufacturerService.findAll();
        model.addAttribute("manufacturers", manufacturers);
        return VIEWS_MANUFACTURERS_LIST;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String initCreateManufacturerForm(Model model) {

        model.addAttribute("manufacturer", new Manufacturer());
        return VIEWS_MANUFACTURER_FORM;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String processCreateManufacturerForm(@Valid Manufacturer manufacturer, BindingResult result,
                                                @RequestParam CommonsMultipartFile fileUpload) {

        brandValidator.validate(manufacturer, result);

        if (fileUpload.isEmpty() || result.hasErrors()) {
            return VIEWS_MANUFACTURER_FORM;
        }

        manufacturerService.addLogoToManufacturer(fileUpload, manufacturer);
        manufacturerService.createManufacturer(manufacturer);
        return REDIRECT_TO + "/admin/manufacturers/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String initUpdateManufacturerForm(@PathVariable Long id, Model model) {

        Manufacturer manufacturer = manufacturerService.read(id);
        model.addAttribute("manufacturer", manufacturer);
        return VIEWS_MANUFACTURER_FORM;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String processUpdateManufacturerForm(@PathVariable Long id, @Valid Manufacturer manufacturer, BindingResult result) {

        if (result.hasErrors()) {
            return VIEWS_MANUFACTURER_FORM;
        }

        manufacturerService.updateManufacturer(manufacturer);
        return REDIRECT_TO + "/admin/manufacturers/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteManufacturer(@PathVariable Long id) {

        manufacturerService.deleteManufacturer(id);
        return REDIRECT_TO + "/admin/manufacturers/list";
    }
}
