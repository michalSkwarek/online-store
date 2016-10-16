package com.skwarek.onlineStore.web.controllers;

import com.skwarek.onlineStore.service.ManufacturerService;
import com.skwarek.onlineStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Michal on 14/10/16.
 */
@Controller
public class ImageController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ManufacturerService manufacturerService;

    @RequestMapping(value = "/productImages/{productId}")
    @ResponseBody
    public byte[] getProductImage(@PathVariable long productId)  {
        return productService.read(productId).getProductImage().getData();
    }

    @RequestMapping(value = "/manufacturerImages/{manufacturerId}")
    @ResponseBody
    public byte[] getManufacturerImage(@PathVariable long manufacturerId)  {
        return manufacturerService.read(manufacturerId).getLogo().getData();
    }
}
