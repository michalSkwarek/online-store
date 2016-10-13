package com.skwarek.onlineStore.web.controllers;

import com.skwarek.onlineStore.data.entity.product.Category;
import com.skwarek.onlineStore.data.entity.product.Manufacturer;
import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.data.entity.product.UploadFile;
import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;
import com.skwarek.onlineStore.data.entity.product.specifications.SpecificationsFactory;
import com.skwarek.onlineStore.service.*;
import com.skwarek.onlineStore.web.editors.CategoryEditor;
import com.skwarek.onlineStore.web.editors.ManufacturerEditor;
import com.skwarek.onlineStore.web.editors.ProductImageEditor;
import com.skwarek.onlineStore.web.editors.ProductSpecificationsEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Michal on 26.09.2016.
 */
@Controller
@RequestMapping(value = { "/products" })
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private ProductSpecificationsService productSpecificationsService;

    @Autowired
    private UploadFileService uploadFileService;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String showProducts(Model model) {

        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        model.addAttribute("manufacturers", manufacturers);
        return "products/list";
    }

    @RequestMapping(value = {"/list"})
    public String showProducts(Model model, @RequestParam(value = "category") String[] categories,
                               @RequestParam(value = "manufacturer") String[] manufacturers,
                               @RequestParam(value = "fromPriceRange") String low,
                               @RequestParam(value = "toPriceRange") String high,
                               @RequestParam String priceOrder) {

        List<Product> products = productService.getProductsByFilter(categories, manufacturers, low, high, priceOrder);
        if (products == null || products.isEmpty()) {
            // TODO: 28.09.2016 Create alert
        }
        model.addAttribute("products", products);
        return "/products/list";
    }


    @RequestMapping("/{id}")
    public String getProductById(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.read(id));
        return "products/specifications";
    }

    @RequestMapping(value = {"/category/{category}"}, method = RequestMethod.GET)
    public String showProductsByCategory(Model model, @PathVariable String category) {

        List products = productService.getProductsByCategory(category);
        model.addAttribute("products", products);
        return "/products/list";
    }

    @RequestMapping(value = {"/manufacturer/{manufacturer}"}, method = RequestMethod.GET)
    public String showProductsByManufacturer(Model model, @PathVariable String manufacturer) {

        List products = productService.getProductsByManufacturer(manufacturer);
        model.addAttribute("products", products);
        return "/products/list";
    }

    @RequestMapping(value = {"/list/price/ascending"}, method = RequestMethod.GET)
    public String showSortedProductsOrderByUnitPriceAscending(Model model) {

        List products = productService.getSortedProductsOrderByUnitPriceAscending();
        model.addAttribute("products", products);
        return "/products/list";
    }

    @RequestMapping(value = {"/list/price/descending"}, method = RequestMethod.GET)
    public String showSortedProductsOrderByUnitPriceDescending(Model model) {

        List products = productService.getSortedProductsOrderByUnitPriceDescending();
        model.addAttribute("products", products);
        return "/products/list";
    }

    @RequestMapping(value = {"/category/select"}, method = RequestMethod.GET)
    public String showProductsByCategoryGet(Model model) {

        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "/products/productsByCategory";
    }

    @RequestMapping(value = {"/category/select"}, method = RequestMethod.POST)
    public String showProductsByCategoryPost(@RequestParam String category, Model model) {

        List products = productService.getProductsByCategory(category);
        if (products == null || products.isEmpty()) {
            // TODO: 28.09.2016 Create alert
        }
        model.addAttribute("products", products);
        return "/products/list";
    }

    @RequestMapping(value = {"/manufacturer/select"}, method = RequestMethod.GET)
    public String showProductsByManufacturerGet(Model model) {

        List<Manufacturer> manufacturers = manufacturerService.getAll();
        model.addAttribute("manufacturers", manufacturers);
        return "/products/productsByManufacturer";
    }

    @RequestMapping(value = {"/manufacturer/select"}, method = RequestMethod.POST)
    public String showProductsByManufacturerPost(@RequestParam String manufacturer, Model model) {

        List products = productService.getProductsByManufacturer(manufacturer);
        if (products == null || products.isEmpty()) {
            // TODO: 28.09.2016 Create alert
        }
        model.addAttribute("products", products);
        return "/products/list";
    }
}