package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.data.entity.product.Manufacturer;
import com.skwarek.onlineStore.data.entity.product.UploadFile;
import com.skwarek.onlineStore.service.ManufacturerService;
import com.skwarek.onlineStore.service.UploadFileService;
import com.skwarek.onlineStore.web.editor.ImageEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * Created by Michal on 27.09.2016.
 */
@Controller
@RequestMapping(value = { "/admin/manufacturers" })
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private UploadFileService uploadFileService;

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
    public String addManufacturer(Manufacturer manufacturer, @RequestParam CommonsMultipartFile fileUpload) {

        if (fileUpload != null) {
            UploadFile uploadFile = new UploadFile();
            uploadFile.setFileName(fileUpload.getOriginalFilename());
            uploadFile.setData(fileUpload.getBytes());
            uploadFileService.create(uploadFile);
            manufacturer.setLogo(uploadFile);
        }

        manufacturerService.create(manufacturer);
        return "redirect:/admin/manufacturers/list";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
    public String getManufacturer(@PathVariable Long id, Model model) {

        Manufacturer manufacturer = manufacturerService.read(id);
        model.addAttribute("manufacturer", manufacturer);
        return "manufacturers/manufacturerData";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
    public String updateManufacturer(@PathVariable Long id, Manufacturer manufacturer) {

        UploadFile logo = uploadFileService.read(manufacturer.getLogo().getId());
        manufacturer.setLogo(logo);
        manufacturerService.update(manufacturer);
        return "redirect:/admin/manufacturers/list";
    }

    @RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
    public String deleteManufacturer(@PathVariable Long id) {

        manufacturerService.deleteManufacturer(id);
        return "redirect:/admin/manufacturers/list";
    }
}
