package com.skwarek.onlineStore.web.validator;

import com.skwarek.onlineStore.data.entity.product.Manufacturer;
import com.skwarek.onlineStore.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Michal on 11/11/2016.
 */
@Component
public class BrandValidator implements Validator {

    @Autowired
    private ManufacturerService manufacturerService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Manufacturer.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Manufacturer manufacturer = (Manufacturer) target;
        if (manufacturerService.getManufacturerByBrand(manufacturer.getBrand()) != null) {
            errors.rejectValue("brand", "Manufacturer.brand.validation.duplicate");
        }
    }
}
