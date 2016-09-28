//package com.skwarek.onlineStore.domain.product.specifications;
//
//import com.skwarek.onlineStore.domain.product.specifications.modules.*;
//
///**
// * Created by Michal on 27.09.2016.
// */
//public class PCSpecifications implements ProductSpecificationsBuilder {
//
//    private ProductSpecifications productSpecifications;
//
//    public PCSpecifications() {
//        this.productSpecifications = new ProductSpecifications();
//    }
//
//    @Override
//    public void buildDisplay() {
//        productSpecifications.setDisplay(new Display(11d, 12, 13));
//    }
//
//    @Override
//    public void buildBattery() {
//        productSpecifications.setBattery(new Battery(14, "type2"));
//    }
//
//    @Override
//    public void buildPowerSupply() {
//        productSpecifications.setPowerSupply(new PowerSupply(500));
//    }
//
//    @Override
//    public void buildOS() {
//        productSpecifications.setOs(new OS("osos1", "16"));
//    }
//
//    @Override
//    public void buildWeight() {
//        productSpecifications.setWeight(new Weight(17));
//    }
//
//    @Override
//    public ProductSpecifications getProductSpecifications() {
//        return productSpecifications;
//    }
//}
