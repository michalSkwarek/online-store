package com.skwarek.onlineStore.web.validator;

import com.skwarek.onlineStore.data.entity.product.Manufacturer;
import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.data.model.order.CartModel;
import com.skwarek.onlineStore.data.model.order.Item;
import com.skwarek.onlineStore.service.ManufacturerService;
import com.skwarek.onlineStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Michal on 12/11/2016.
 */
@Component
public class QuantityValidator implements Validator {

    @Autowired
    private ProductService productService;

    @Override
    public boolean supports(Class<?> aClass) {
        return CartModel.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CartModel cart = (CartModel) target;
        for (Item item : cart.getItems()) {
            Product product = productService.getProductByModel(item.getProduct().getModel());
            if (item.getQuantity() > product.getUnitsInMagazine()) {
                System.out.println("dupa " + item.getQuantity() + " " + product.getUnitsInMagazine());
//                errors.rejectValue("quantity", "Item.quantity.validation.incorrectNumberOfPieces");
            }
        }
    }
}
