package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.domain.product.Product;
import com.skwarek.onlineStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Michal on 26.09.2016.
 */
@Controller
@RequestMapping(value = { "/products" })
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = { "/list" }, method = RequestMethod.GET)
    public String showProducts(Model model) {

        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "products/list";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String createProduct(Model model) {

        model.addAttribute("product", new Product());
        return "products/productData";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String addProduct(Product product) {

        productService.save(product);
        return "redirect:/products/list";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
    public String getProduct(@PathVariable Long id, Model model) {

        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "products/productData";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
    public String updateProduct(@PathVariable Long id, Product product) {

        productService.update(product);
        return "redirect:/products/list";
    }

    @RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
    public String deleteProduct(@PathVariable Long id) {

        productService.removeProduct(id);
        return "redirect:/products/list";
    }
}

