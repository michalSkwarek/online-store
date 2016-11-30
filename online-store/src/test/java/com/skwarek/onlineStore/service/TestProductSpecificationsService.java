package com.skwarek.onlineStore.service;

import com.skwarek.onlineStore.configuration.ApplicationContextConfiguration;
import com.skwarek.onlineStore.data.entity.product.Category;
import com.skwarek.onlineStore.data.entity.product.Manufacturer;
import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.data.entity.product.UploadFile;
import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;
import com.skwarek.onlineStore.data.entity.product.specifications.modules.*;
import org.hibernate.SessionFactory;
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
public class TestProductSpecificationsService {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductSpecificationsService specificationsService;

    @Autowired
    private SessionFactory sessionFactory;

    private static Product newProduct;
    private static Category newCategory;
    private static Manufacturer newManufacturer;
    private static UploadFile logo;
    private static UploadFile productImage;
    private static ProductSpecifications newSpecifications;
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
        newCategory.setName("Smartphone");

        logo = new UploadFile();
        logo.setFileName("Magic Apple logo");

        newManufacturer = new Manufacturer();
        newManufacturer.setBrand("Magic Apple");
        newManufacturer.setLogo(logo);
        newManufacturer.setWebsite("http://www.magic-apple.com");

        productImage = new UploadFile();
        productImage.setFileName("Magic iPhone 7 image");

        newCpu = new CPU();
        newCpu.setModel("Magic Apple A10");
        newCpu.setNumberOfCores(4);
        newCpu.setLowClockSpeed(2.4);

        newGpu = new GPU();
        newGpu.setModel("Magic PowerVR GT7600");

        newRam = new RAM();
        newRam.setValue(4);

        newStorage = new Storage();
        newStorage.setDiskMemory(128);

        newDisplay = new Display();
        newDisplay.setDiagonal(5.5);
        newDisplay.setWidthInPixels(2000);
        newDisplay.setHeightInPixels(1000);

        newBattery = new Battery();
        newBattery.setCapacity(2910);
        newBattery.setType("Li-ion");

        newOs = new OS();
        newOs.setName("Magic iOS");
        newOs.setVersion("10");

        newCamera = new Camera();
        newCamera.setResolutionMainCamera(12.0);
        newCamera.setResolutionFrontCamera(7.0);

        newDimensions = new Dimensions();
        newDimensions.setThickness(7.3);
        newDimensions.setWidth(77.9);
        newDimensions.setHeight(158.2);

        newWeight = new Weight();
        newWeight.setValue(189.0);

        newSpecifications = new ProductSpecifications();
        newSpecifications.setCpu(newCpu);
        newSpecifications.setGpu(newGpu);
        newSpecifications.setRam(newRam);
        newSpecifications.setStorage(newStorage);
        newSpecifications.setDisplay(newDisplay);
        newSpecifications.setBattery(newBattery);
        newSpecifications.setOs(newOs);
        newSpecifications.setCamera(newCamera);
        newSpecifications.setDimensions(newDimensions);
        newSpecifications.setWeight(newWeight);

        newProduct = new Product();
        newProduct.setModel("Magic iPhone 7");
        newProduct.setUnitPrice(new BigDecimal(4000.00));
        newProduct.setCategory(newCategory);
        newProduct.setManufacturer(newManufacturer);
        newProduct.setProductImage(productImage);
        newProduct.setProductSpecifications(newSpecifications);
        newProduct.setUnitsInMagazine(10L);
    }

    @Test
    public void testCreateSpecificationsWithoutExistingData() {
        newProduct.setProductSpecifications(null);
        productService.create(newProduct);
        int oldSize = specificationsService.findAll().size();
        long oldSizeCpu = cpuCounter();
        long oldSizeGpu = gpuCounter();
        long oldSizeDisplay = displayCounter();
        long oldSizeOs = osCounter();
        specificationsService.createSpecifications(newSpecifications, newProduct);
        assertTrue(oldSize + 1 == specificationsService.findAll().size());
        assertTrue(oldSizeCpu + 1 == cpuCounter());
        assertTrue(oldSizeGpu + 1 == gpuCounter());
        assertTrue(oldSizeDisplay + 1 == displayCounter());
        assertTrue(oldSizeOs + 1 == osCounter());
    }

    @Test
    public void testCreateSpecificationsWithExistingData() {
        newProduct.setProductSpecifications(null);
        productService.create(newProduct);
        specificationsService.createSpecifications(newSpecifications, newProduct);
        int oldSize = specificationsService.findAll().size();
        long oldSizeCpu = cpuCounter();
        long oldSizeGpu = gpuCounter();
        long oldSizeDisplay = displayCounter();
        long oldSizeOs = osCounter();
        newProduct.setModel("Magic Samsung");
        newProduct.setProductSpecifications(null);
        productService.create(newProduct);
        specificationsService.createSpecifications(newSpecifications, newProduct);
        assertTrue(oldSize == specificationsService.findAll().size());
        assertTrue(oldSizeCpu == cpuCounter());
        assertTrue(oldSizeGpu == gpuCounter());
        assertTrue(oldSizeDisplay == displayCounter());
        assertTrue(oldSizeOs == osCounter());
    }

    private long cpuCounter() {
        return (long) sessionFactory.getCurrentSession().createQuery("select count(*) from CPU").uniqueResult();
    }

    private long gpuCounter() {
        return (long) sessionFactory.getCurrentSession().createQuery("select count(*) from GPU").uniqueResult();
    }

    private long displayCounter() {
        return (long) sessionFactory.getCurrentSession().createQuery("select count(*) from Display").uniqueResult();
    }

    private long osCounter() {
        return (long) sessionFactory.getCurrentSession().createQuery("select count(*) from OS").uniqueResult();
    }

    @Test
    public void testUpdateSpecifications() {
        newProduct.setProductSpecifications(null);
        productService.create(newProduct);
        specificationsService.createSpecifications(newSpecifications, newProduct);

        newCpu.setModel("Magic Samsung");
        newCpu.setNumberOfCores(5);
        newCpu.setLowClockSpeed(3.4);
        newGpu.setModel("Magic PowerVR GT7600");
        newRam.setValue(8);
        newStorage.setDiskMemory(256);
        newDisplay.setDiagonal(6.5);
        newDisplay.setWidthInPixels(3000);
        newDisplay.setHeightInPixels(2000);
        newBattery.setCapacity(3000);
        newBattery.setType("Li-poly");
        newOs.setName("Magic Android");
        newOs.setVersion("Marshmallow");
        newCamera.setResolutionMainCamera(15.0);
        newCamera.setResolutionFrontCamera(5.0);
        newDimensions.setThickness(8.3);
        newDimensions.setWidth(80.9);
        newDimensions.setHeight(168.2);
        newWeight.setValue(199.0);

        specificationsService.updateSpecifications(newSpecifications);
        ProductSpecifications found = specificationsService.read(newSpecifications.getId());

        assertEquals("Magic Samsung", found.getCpu().getModel());
        assertEquals(5, (int) found.getCpu().getNumberOfCores());
        assertEquals(3.4, found.getCpu().getLowClockSpeed());
        assertEquals("Magic PowerVR GT7600", found.getGpu().getModel());
        assertEquals(8, (int) found.getRam().getValue());
        assertEquals(256, (int) found.getStorage().getDiskMemory());
        assertEquals(6.5, found.getDisplay().getDiagonal());
        assertEquals(3000, (int) found.getDisplay().getWidthInPixels());
        assertEquals(2000, (int) found.getDisplay().getHeightInPixels());
        assertEquals(3000, (int) found.getBattery().getCapacity());
        assertEquals("Li-poly", found.getBattery().getType());
        assertEquals("Magic Android", found.getOs().getName());
        assertEquals("Marshmallow", found.getOs().getVersion());
        assertEquals(15.0, found.getCamera().getResolutionMainCamera());
        assertEquals(5.0, found.getCamera().getResolutionFrontCamera());
        assertEquals(8.3, found.getDimensions().getThickness());
        assertEquals(80.9, found.getDimensions().getWidth());
        assertEquals(168.2, found.getDimensions().getHeight());
        assertEquals(199.0, found.getWeight().getValue());
    }
}
