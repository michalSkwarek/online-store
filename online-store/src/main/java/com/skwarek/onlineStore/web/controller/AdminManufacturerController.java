package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.data.entity.product.Manufacturer;
import com.skwarek.onlineStore.data.entity.product.UploadFile;
import com.skwarek.onlineStore.service.ManufacturerService;
import com.skwarek.onlineStore.service.UploadFileService;
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

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private UploadFileService uploadFileService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showProducts(Model model) {

        List<Manufacturer> manufacturers = manufacturerService.getAll();
        model.addAttribute("manufacturers", manufacturers);
        return "manufacturers/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String createManufacturer(Model model) {

        model.addAttribute("manufacturer", new Manufacturer());
        return "manufacturers/manufacturerData";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addManufacturer(@Valid Manufacturer manufacturer, BindingResult result, @RequestParam CommonsMultipartFile fileUpload) {

        if (fileUpload.isEmpty() || result.hasErrors()) {
            return "manufacturers/manufacturerData";
        }

        UploadFile uploadFile = new UploadFile();
        uploadFile.setFileName(fileUpload.getOriginalFilename());
        uploadFile.setData(fileUpload.getBytes());
        uploadFileService.create(uploadFile);
        manufacturer.setLogo(uploadFile);

        manufacturerService.create(manufacturer);
        return "redirect:/admin/manufacturers/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getManufacturer(@PathVariable Long id, Model model) {

        Manufacturer manufacturer = manufacturerService.read(id);
        model.addAttribute("manufacturer", manufacturer);
        return "manufacturers/manufacturerData";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateManufacturer(@PathVariable Long id, @Valid Manufacturer manufacturer, BindingResult result) {

        if (result.hasErrors()) {
            return "manufacturers/manufacturerData";
        }

        manufacturerService.updateManufacturer(manufacturer);
        return "redirect:/admin/manufacturers/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteManufacturer(@PathVariable Long id) {

        manufacturerService.deleteManufacturer(id);
        return "redirect:/admin/manufacturers/list";
    }
}
