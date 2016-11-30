package com.skwarek.onlineStore.service;

import com.skwarek.onlineStore.configuration.ApplicationContextConfiguration;
import com.skwarek.onlineStore.data.entity.product.Category;
import com.skwarek.onlineStore.data.entity.product.Manufacturer;
import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.data.entity.product.UploadFile;
import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;
import com.skwarek.onlineStore.data.model.product.specifications.SpecificationsFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static junit.framework.Assert.*;

/**
 * Created by Michal on 25/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
@WebAppConfiguration
@Transactional
public class TestManufacturerService {

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private ProductService productService;

    private static Product newProduct;
    private static Manufacturer newManufacturer;
    private static UploadFile logo;

    @Before
    public void setUp() {
        logo = new UploadFile();
        logo.setFileName("Magic Apple logo");

        newManufacturer = new Manufacturer();
        newManufacturer.setBrand("Magic Apple");
        newManufacturer.setLogo(logo);
        newManufacturer.setWebsite("http://www.magic-apple.com");

        newProduct = new Product();
        newProduct.setModel("Magic iPhone 7");
        newProduct.setUnitPrice(new BigDecimal(4000));
        newProduct.setManufacturer(newManufacturer);
        newProduct.setUnitsInMagazine(10L);
    }

    @Test
    public void testDeleteManufacturerWithRelatedProducts() {
        productService.create(newProduct);
        int oldSize = manufacturerService.findAll().size();
        manufacturerService.deleteManufacturer(newManufacturer.getId());
        assertTrue(oldSize == manufacturerService.findAll().size());
    }

    @Test
    public void testDeleteManufacturerWithoutRelatedProducts() {
        manufacturerService.create(newManufacturer);
        int oldSize = manufacturerService.findAll().size();
        manufacturerService.deleteManufacturer(newManufacturer.getId());
        assertTrue(oldSize - 1 == manufacturerService.findAll().size());
    }

    @Test
    public void testUpdateManufacturer() {
        manufacturerService.create(newManufacturer);
        newManufacturer.setBrand("Magic Samsung");
        newManufacturer.setWebsite("http://www.magic-samsung.com");
        manufacturerService.updateManufacturer(newManufacturer);
        assertEquals("Magic Samsung", newManufacturer.getBrand());
        assertEquals("http://www.magic-samsung.com", newManufacturer.getWebsite());
    }

    @Test
    public void testFindManufacturerByBrand() {
        String brand = "Magic Apple";
        Manufacturer notExistingManufacturer = manufacturerService.findManufacturerByBrand(brand);
        assertNull(notExistingManufacturer);
        manufacturerService.create(newManufacturer);
        Manufacturer existingManufacturer = manufacturerService.findManufacturerByBrand(brand);
        assertNotNull(existingManufacturer);
        assertEquals(newManufacturer, existingManufacturer);
    }
}