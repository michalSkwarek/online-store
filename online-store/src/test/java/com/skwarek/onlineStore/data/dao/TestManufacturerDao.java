package com.skwarek.onlineStore.data.dao;

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

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Michal on 25/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
@WebAppConfiguration
@Transactional
public class TestManufacturerDao {

    @Autowired
    private ManufacturerDao manufacturerDao;

    @Autowired
    private ProductDao productDao;

    private static Product newProduct;
    private static Category newCategory;
    private static Manufacturer newManufacturer;
    private static UploadFile logo;
    private static UploadFile productImage;
    private static ProductSpecifications specifications;

    @Before
    public void setUp() {
        newCategory = new Category();
        newCategory.setName("Samrtphone");

        logo = new UploadFile();
        logo.setFileName("Apple");

        newManufacturer = new Manufacturer();
        newManufacturer.setBrand("Apple");
        newManufacturer.setLogo(logo);
        newManufacturer.setWebsite("http://www.apple.com");

        productImage = new UploadFile();
        productImage.setFileName("iPhone 7");

        SpecificationsFactory factory = new SpecificationsFactory();
        specifications = factory.createSpecifications(newCategory.getName());

        newProduct = new Product();
        newProduct.setModel("iPhone 7");
        newProduct.setUnitPrice(new BigDecimal(4000.00));
        newProduct.setCategory(newCategory);
        newProduct.setManufacturer(newManufacturer);
        newProduct.setProductImage(productImage);
        newProduct.setProductSpecifications(specifications);
        newProduct.setUnitsInMagazine(10L);
    }

    @Test
    public void testDeleteManufacturerWithRelatedProducts() {
        productDao.create(newProduct);
        int oldSize = manufacturerDao.findAll().size();
        manufacturerDao.deleteManufacturer(newManufacturer.getId());
        assertTrue(oldSize == manufacturerDao.findAll().size());
    }

    @Test
    public void testDeleteManufacturerWithoutRelatedProducts() {
        manufacturerDao.create(newManufacturer);
        int oldSize = manufacturerDao.findAll().size();
        manufacturerDao.deleteManufacturer(newManufacturer.getId());
        assertTrue(oldSize > manufacturerDao.findAll().size());
    }

    @Test
    public void testUpdateManufacturer() {
        manufacturerDao.create(newManufacturer);
        newManufacturer.setBrand("Samsung");
        newManufacturer.setWebsite("http://www.samsung.com");
        manufacturerDao.updateManufacturer(newManufacturer);
        assertEquals("Samsung", newManufacturer.getBrand());
        assertEquals("http://www.samsung.com", newManufacturer.getWebsite());
    }

    @Test
    public void testFindManufacturerByBrand() {
        manufacturerDao.create(newManufacturer);
        String brand = "Apple";
        Manufacturer found = manufacturerDao.findManufacturerByBrand(brand);
        assertEquals(newManufacturer, found);
    }
}
