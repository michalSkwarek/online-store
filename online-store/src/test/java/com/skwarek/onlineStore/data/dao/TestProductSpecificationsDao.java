package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.configuration.ApplicationContextConfiguration;
import com.skwarek.onlineStore.data.entity.product.Category;
import com.skwarek.onlineStore.data.entity.product.Manufacturer;
import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.data.entity.product.UploadFile;
import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;
import com.skwarek.onlineStore.data.entity.product.specifications.modules.*;
import com.skwarek.onlineStore.data.model.product.specifications.SpecificationsFactory;
import org.hibernate.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * Created by Michal on 25/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
@WebAppConfiguration
@Transactional
public class TestProductSpecificationsDao {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductSpecificationsDao specificationsDao;

    private static Product newProduct;
    private static Category newCategory;
    private static Manufacturer newManufacturer;
    private static UploadFile logo;
    private static UploadFile productImage;
    private static ProductSpecifications specifications;
    private static CPU newCpu;
    private static GPU newGpu;
    private static RAM newRam;
    private static Storage newStorage;
    private static Display newDisplay;
    private static Battery newBattery;
    private static OS newOs;
    private static Camera newCamera;
    private static Dimensions newDimensions;
    private static Weight newWeight;

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

        newCpu = new CPU();
        newCpu.setModel("Apple A10");
        newCpu.setNumberOfCores(4);
        newCpu.setLowClockSpeed(2.4);

        newGpu = new GPU();
        newGpu.setModel("PowerVR GT7600");

        newRam = new RAM();
        newRam.setValue(4);

        newStorage = new Storage();
        newStorage.setDiskMemory(128);

        newDisplay = new Display();
        newDisplay.setDiagonal(5.5);
        newDisplay.setWidthInPixels(1920);
        newDisplay.setHeightInPixels(1080);

        newBattery = new Battery();
        newBattery.setCapacity(2910);
        newBattery.setType("Li-ion");

        newOs = new OS();
        newOs.setName("iOS");
        newOs.setVersion("10");

        newCamera = new Camera();
        newCamera.setResolutionMainCamera(12.0);
        newCamera.setResolutionFrontCamera(7.0);

        newDimensions = new Dimensions();
        newDimensions.setWidth(7.3);
        newDimensions.setHeight(77.9);
        newDimensions.setThickness(158.2);

        newWeight = new Weight();
        newWeight.setValue(189.0);

        SpecificationsFactory factory = new SpecificationsFactory();
        specifications = factory.createSpecifications("Smartphone");
        specifications.setCpu(newCpu);
        specifications.setGpu(newGpu);
        specifications.setRam(newRam);
        specifications.setStorage(newStorage);
        specifications.setDisplay(newDisplay);
        specifications.setBattery(newBattery);
        specifications.setOs(newOs);
        specifications.setCamera(newCamera);
        specifications.setDimensions(newDimensions);
        specifications.setWeight(newWeight);

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
    public void testCreateSpecificationsWithoutExistingData() {
        newProduct.setProductSpecifications(null);
        productDao.create(newProduct);
        int oldSize = specificationsDao.findAll().size();
        System.out.println("dupa " + oldSize);
        newProduct.setProductSpecifications(specifications);

    }

//    private int cpusCounter() {
//        Query query =
//        return cities.size();
//    }

    @Test
    public void testCreateSpecificationsWithExistingData() {

    }

    @Test
    public void testUpdateSpecifications() {

    }
}
