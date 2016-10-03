package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.data.entity.product.Category;
import com.skwarek.onlineStore.data.entity.product.Manufacturer;
import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;
import com.skwarek.onlineStore.data.entity.product.specifications.SpecificationsFactory;
import com.skwarek.onlineStore.service.CategoryService;
import com.skwarek.onlineStore.service.ManufacturerService;
import com.skwarek.onlineStore.service.ProductService;
import com.skwarek.onlineStore.service.ProductSpecificationsService;
import com.skwarek.onlineStore.web.editors.CategoryEditor;
import com.skwarek.onlineStore.web.editors.ManufacturerEditor;
import com.skwarek.onlineStore.web.editors.ProductSpecificationsEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
        binder.registerCustomEditor(Manufacturer.class, new ManufacturerEditor(manufacturerService));
        binder.registerCustomEditor(ProductSpecifications.class, new ProductSpecificationsEditor(productSpecificationsService));
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String showProducts(Model model) {

        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "products/list";
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

    @RequestMapping("/{id}")
    public String getProductById(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.read(id));
        return "products/specifications";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String createProduct(Model model) {

        model.addAttribute("product", new Product());
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        model.addAttribute("manufacturers", manufacturers);
        return "products/productData";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String addProduct(Product product) {

        productService.create(product);
        return "redirect:/products/list";
    }

    @RequestMapping(value = {"/spec/{id}"}, method = RequestMethod.GET)
    public String createSpec(@PathVariable Long id, Model model) {

        String productCategory = productService.read(id).getCategory().getName();

        SpecificationsFactory factory = new SpecificationsFactory();
        ProductSpecifications specifications = factory.createSpecifications(productCategory);

        model.addAttribute("spec", specifications);
        return "products/addSpecifications";
    }

    @RequestMapping(value = {"/spec/{id}"}, method = RequestMethod.POST)
    public String addSpecToProduct(@PathVariable Long id, ProductSpecifications specifications) {

        productSpecificationsService.create(specifications);
        Product product = productService.read(id);
        product.setProductSpecifications(specifications);
        productService.update(product);
        return "redirect:/products/list";
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.GET)
    public String getProduct(@PathVariable Long id, Model model) {

        Product product = productService.read(id);
        model.addAttribute("product", product);
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        model.addAttribute("manufacturers", manufacturers);
        return "products/productData";
    }

    //TODO
    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.POST)
    public String updateProduct(@PathVariable Long id, Product product) {

        productService.update(product);
        return "redirect:/products/list";
    }

    @RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.GET)
    public String deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);
        return "redirect:/products/list";
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