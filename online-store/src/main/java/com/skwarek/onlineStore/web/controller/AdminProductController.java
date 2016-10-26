package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.data.entity.product.Category;
import com.skwarek.onlineStore.data.entity.product.Manufacturer;
import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.data.entity.product.UploadFile;
import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;
import com.skwarek.onlineStore.data.model.product.specifications.SpecificationsFactory;
import com.skwarek.onlineStore.service.*;
import com.skwarek.onlineStore.web.editor.CategoryEditor;
import com.skwarek.onlineStore.web.editor.ManufacturerEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * Created by Michal on 12/10/16.
 */
@Controller
@RequestMapping(value = "/admin/products")
public class AdminProductController {

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

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
        binder.registerCustomEditor(Manufacturer.class, new ManufacturerEditor(manufacturerService));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showProducts(Model model) {

        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        addAllCategoriesAndManufacturersToModel(model);
        return "products/adminList";
    }

    @RequestMapping(value = "/{id}")
    public String getProductById(Model model, @PathVariable Long id) {

        model.addAttribute("product", productService.read(id));
        return "products/specifications";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String createProduct(Model model) {

        model.addAttribute("product", new Product());
        addAllCategoriesAndManufacturersToModel(model);
        return "products/productData";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addProduct(Product product, @RequestParam CommonsMultipartFile fileUpload) {

        if (fileUpload != null) {
            UploadFile uploadFile = new UploadFile();
            uploadFile.setFileName(fileUpload.getOriginalFilename());
            uploadFile.setData(fileUpload.getBytes());
            uploadFileService.create(uploadFile);
            product.setProductImage(uploadFile);
        }

        productService.create(product);
        return "redirect:/admin/products/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getProduct(@PathVariable Long id, Model model) {

        Product product = productService.read(id);
        model.addAttribute("product", product);
        addAllCategoriesAndManufacturersToModel(model);
        return "products/productData";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateProduct(@PathVariable Long id, Product product) {

        productService.updateProduct(product);
        return "redirect:/admin/products/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);
        return "redirect:/admin/products/list";
    }

    private void addAllCategoriesAndManufacturersToModel(Model model) {
        List<Category> categoriesAll = categoryService.getAll();
        model.addAttribute("categories", categoriesAll);
        List<Manufacturer> manufacturersAll = manufacturerService.getAll();
        model.addAttribute("manufacturers", manufacturersAll);
    }

//----------------------------------------------------------------------------------------------------------------------

    @RequestMapping(value = "/spec/{id}", method = RequestMethod.GET)
    public String createSpecifications(@PathVariable Long id, Model model) {

        String productCategory = productService.read(id).getCategory().getName();
        SpecificationsFactory factory = new SpecificationsFactory();
        ProductSpecifications specifications = factory.createSpecifications(productCategory);
        model.addAttribute("spec", specifications);
        return "products/addSpecifications";
    }

    @RequestMapping(value = "/spec/{id}", method = RequestMethod.POST)
    public String addSpecificationsToProduct(@PathVariable Long id, ProductSpecifications specifications) {

        Product product = productService.read(id);
        productSpecificationsService.createSpecifications(specifications, product);
        return "redirect:/admin/products/list";
    }

    @RequestMapping(value = "/spec/edit/{id}", method = RequestMethod.GET)
    public String getSpecifications(@PathVariable Long id, Model model) {

        ProductSpecifications specifications = productSpecificationsService.read(id);
        model.addAttribute("spec", specifications);
        return "products/addSpecifications";
    }

    @RequestMapping(value = "/spec/edit/{id}", method = RequestMethod.POST)
    public String updateSpecifications(@PathVariable Long id, ProductSpecifications specifications) {

        productSpecificationsService.updateSpecifications(specifications);
        return "redirect:/admin/products/list";
    }
}
