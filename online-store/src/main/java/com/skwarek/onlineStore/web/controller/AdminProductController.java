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
import com.skwarek.onlineStore.web.validator.ModelValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Michal on 12/10/16.
 */
@Controller
@RequestMapping(value = "/admin/products")
public class AdminProductController {

    private static final String VIEWS_PRODUCTS_ADMIN_LIST = "products/adminList";
    private static final String VIEWS_PRODUCT_FORM = "products/productData";
    private static final String VIEWS_PRODUCT_SPECIFICATIONS = "products/specifications";
    private static final String VIEWS_PRODUCT_SPECIFICATIONS_FORM = "products/addSpecifications";
    private final ProductService productService;
    private final CategoryService categoryService;
    private final ManufacturerService manufacturerService;
    private final ProductSpecificationsService productSpecificationsService;
    private final UploadFileService uploadFileService;
    private final ModelValidator modelValidator;

    @Autowired
    public AdminProductController(ProductService productService, CategoryService categoryService,
                                  ManufacturerService manufacturerService, ProductSpecificationsService productSpecificationsService,
                                  UploadFileService uploadFileService, ModelValidator modelValidator) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.manufacturerService = manufacturerService;
        this.productSpecificationsService = productSpecificationsService;
        this.uploadFileService = uploadFileService;
        this.modelValidator = modelValidator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
        binder.registerCustomEditor(Manufacturer.class, new ManufacturerEditor(manufacturerService));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showProducts(Model model) {

        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        addAllCategoriesAndManufacturersToModel(model);
        return VIEWS_PRODUCTS_ADMIN_LIST;
    }

    @RequestMapping(value = "/{id}")
    public String getProductById(Model model, @PathVariable Long id) {

        model.addAttribute("product", productService.read(id));
        return VIEWS_PRODUCT_SPECIFICATIONS;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String initCreateProductForm(Model model) {

        model.addAttribute("product", new Product());
        addAllCategoriesAndManufacturersToModel(model);
        return VIEWS_PRODUCT_FORM;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String processCreateProductForm(Model model, @Valid Product product, BindingResult result, @RequestParam CommonsMultipartFile fileUpload) {

        modelValidator.validate(product, result);

        if (fileUpload.isEmpty() || result.hasErrors()) {
            addAllCategoriesAndManufacturersToModel(model);
            return VIEWS_PRODUCT_FORM;
        }

        UploadFile uploadFile = new UploadFile();
        uploadFile.setFileName(fileUpload.getOriginalFilename());
        uploadFile.setData(fileUpload.getBytes());
        uploadFileService.create(uploadFile);
        product.setProductImage(uploadFile);

        productService.create(product);
        return "redirect:/admin/products/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String initUpdateProductForm(@PathVariable Long id, Model model) {

        Product product = productService.read(id);
        model.addAttribute("product", product);
        addAllCategoriesAndManufacturersToModel(model);
        return VIEWS_PRODUCT_FORM;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String processUpdateProductForm(Model model, @PathVariable Long id, @Valid Product product, BindingResult result) {

        if (result.hasErrors()) {
            addAllCategoriesAndManufacturersToModel(model);
            return VIEWS_PRODUCT_FORM;
        }

        productService.updateProduct(product);
        return "redirect:/admin/products/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);
        return "redirect:/admin/products/list";
    }

    private void addAllCategoriesAndManufacturersToModel(Model model) {

        List<Category> categoriesAll = categoryService.findAll();
        model.addAttribute("categories", categoriesAll);
        List<Manufacturer> manufacturersAll = manufacturerService.findAll();
        model.addAttribute("manufacturers", manufacturersAll);
    }

//----------------------------------------------------------------------------------------------------------------------

    @RequestMapping(value = "/spec/{id}", method = RequestMethod.GET)
    public String initCreateSpecificationsForm(@PathVariable Long id, Model model) {

        String productCategory = productService.read(id).getCategory().getName();
        SpecificationsFactory factory = new SpecificationsFactory();
        ProductSpecifications specifications = factory.createSpecifications(productCategory);
        model.addAttribute("spec", specifications);
        return VIEWS_PRODUCT_SPECIFICATIONS_FORM;
    }

    @RequestMapping(value = "/spec/{id}", method = RequestMethod.POST)
    public String processCreateSpecificationsForm(Model model, @PathVariable Long id, @Valid ProductSpecifications spec, BindingResult result) {

        if (result.hasErrors()) {
            errorsHandling(model, spec, result);
            return VIEWS_PRODUCT_SPECIFICATIONS_FORM;
        }

        Product product = productService.read(id);
        productSpecificationsService.createSpecifications(spec, product);
        return "redirect:/admin/products/list";
    }

    @RequestMapping(value = "/spec/edit/{id}", method = RequestMethod.GET)
    public String initUpdateSpecificationsForm(@PathVariable Long id, Model model) {

        ProductSpecifications specifications = productSpecificationsService.read(id);
        model.addAttribute("spec", specifications);
        return VIEWS_PRODUCT_SPECIFICATIONS_FORM;
    }

    @RequestMapping(value = "/spec/edit/{id}", method = RequestMethod.POST)
    public String processUpdateSpecificationsForm(Model model, @PathVariable Long id, @Valid ProductSpecifications spec, BindingResult result) {

        if (result.hasErrors()) {
            errorsHandling(model, spec, result);
            return VIEWS_PRODUCT_SPECIFICATIONS_FORM;
        }

        productSpecificationsService.updateSpecifications(spec);
        return "redirect:/admin/products/list";
    }

    private void errorsHandling(Model model, @Valid ProductSpecifications spec, BindingResult result) {

        List<String> errors = new LinkedList<>();
        for (Object object : result.getAllErrors()) {
            ObjectError objectError = (ObjectError) object;
            errors.add(objectError.getDefaultMessage());
        }
        model.addAttribute("spec", spec);
        model.addAttribute("errors", errors);
    }
}
