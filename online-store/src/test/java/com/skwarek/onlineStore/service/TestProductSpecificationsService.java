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
import static org.junit.Assert.*;

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

    private Product newProduct;
    private Category newCategory;
    private Manufacturer newManufacturer;
    private UploadFile logo;
    private UploadFile productImage;
    private ProductSpecifications newSpecifications;
    private CPU newCpu;
    private GPU newGpu;
    private RAM newRam;
    private Storage newStorage;
    private Display newDisplay;
    private Battery newBattery;
    private OS newOs;
    private Camera newCamera;
    private Dimensions newDimensions;
    private Weight newWeight;

    @Before
    public void setUp() {
        this.newCategory = new Category();
        this.newCategory.setName("Smartphone");

        this.logo = new UploadFile();
        this.logo.setFileName("Magic Apple logo");

        this.newManufacturer = new Manufacturer();
        this.newManufacturer.setBrand("Magic Apple");
        this.newManufacturer.setLogo(logo);
        this.newManufacturer.setWebsite("http://www.magic-apple.com");

        this.productImage = new UploadFile();
        this.productImage.setFileName("Magic iPhone 7 image");

        this.newCpu = new CPU();
        this.newCpu.setModel("Magic Apple A10");
        this.newCpu.setNumberOfCores(4);
        this.newCpu.setLowClockSpeed(2.4);

        this.newGpu = new GPU();
        this.newGpu.setModel("Magic PowerVR GT7600");

        this.newRam = new RAM();
        this.newRam.setValue(4);

        this.newStorage = new Storage();
        this.newStorage.setDiskMemory(128);

        this.newDisplay = new Display();
        this.newDisplay.setDiagonal(5.5);
        this.newDisplay.setWidthInPixels(2000);
        this.newDisplay.setHeightInPixels(1000);

        this.newBattery = new Battery();
        this.newBattery.setCapacity(2910);
        this.newBattery.setType("Li-ion");

        this.newOs = new OS();
        this.newOs.setName("Magic iOS");
        this.newOs.setVersion("10");

        this.newCamera = new Camera();
        this.newCamera.setResolutionMainCamera(12.0);
        this.newCamera.setResolutionFrontCamera(7.0);

        this.newDimensions = new Dimensions();
        this.newDimensions.setThickness(7.3);
        this.newDimensions.setWidth(77.9);
        this.newDimensions.setHeight(158.2);

        this.newWeight = new Weight();
        this.newWeight.setValue(189.0);

        this.newSpecifications = new ProductSpecifications();
        this.newSpecifications.setCpu(newCpu);
        this.newSpecifications.setGpu(newGpu);
        this.newSpecifications.setRam(newRam);
        this.newSpecifications.setStorage(newStorage);
        this.newSpecifications.setDisplay(newDisplay);
        this.newSpecifications.setBattery(newBattery);
        this.newSpecifications.setOs(newOs);
        this.newSpecifications.setCamera(newCamera);
        this.newSpecifications.setDimensions(newDimensions);
        this.newSpecifications.setWeight(newWeight);

        this.newProduct = new Product();
        this.newProduct.setModel("Magic iPhone 7");
        this.newProduct.setUnitPrice(new BigDecimal(4000.00));
        this.newProduct.setCategory(newCategory);
        this.newProduct.setManufacturer(newManufacturer);
        this.newProduct.setProductImage(productImage);
        this.newProduct.setProductSpecifications(newSpecifications);
        this.newProduct.setUnitsInMagazine(10L);
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
