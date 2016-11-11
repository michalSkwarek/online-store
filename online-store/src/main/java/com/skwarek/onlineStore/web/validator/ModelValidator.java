package com.skwarek.onlineStore.web.validator;

import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Michal on 11/11/2016.
 */
@Component
public class ModelValidator implements Validator {

    @Autowired
    private ProductService productService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        if (productService.getProductByModel(product.getModel()) != null) {
            errors.rejectValue("model", "Product.model.validation.duplicate");
        }
    }
}
