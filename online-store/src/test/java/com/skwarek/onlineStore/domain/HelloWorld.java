package com.skwarek.onlineStore.domain;

import com.skwarek.onlineStore.domain.product.Category;
import com.skwarek.onlineStore.domain.product.Manufacturer;
import com.skwarek.onlineStore.domain.product.Product;
import com.skwarek.onlineStore.domain.product.specifications.*;
import com.skwarek.onlineStore.domain.product.specifications.modules.*;
import com.skwarek.onlineStore.service.CategoryService;
import com.skwarek.onlineStore.service.ManufacturerService;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Michal on 26.09.2016.
 */
public class HelloWorld {

    @Test
    public void myTest() {

        Product product = new Product();
        product.setModel("dupa");
        product.setUnitPrice(new BigDecimal(1000));
        Category category = new Category("category1");
        Manufacturer manufacturer = new Manufacturer("brand1", "website1");
        product.setCategory(category);
        product.setManufacturer(manufacturer);
        ProductSpecifications productSpecifications = new ProductSpecifications(
                new Display(1d, 2, 3),
                new Battery(4, "type1"),
                new PowerSupply(5),
                new OS("osos", "6"),
                new Weight(7));
        product.setProductSpecifications(productSpecifications);

        System.out.println(product);

        ProductSpecificationsBuilder smartphoneSpecBuilder = new SmartphoneSpecifications();

        ConstructionEngineer engineer1 = new ConstructionEngineer(smartphoneSpecBuilder);
        ProductSpecifications smartphoneSpec = engineer1.build();

        System.out.println(" = = = " + smartphoneSpec);


    }
}
