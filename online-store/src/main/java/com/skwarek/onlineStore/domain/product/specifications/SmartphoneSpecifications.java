package com.skwarek.onlineStore.domain.product.specifications;

import com.skwarek.onlineStore.domain.product.specifications.modules.*;

/**
 * Created by Michal on 27.09.2016.
 */
public class SmartphoneSpecifications extends ProductSpecifications {

    public SmartphoneSpecifications() {
        setCpu(new CPU());
//        setDisplay(new Display());
//        setBattery(new Battery());
//        setOs(new OS());
//        setWeight(new Weight());
    }
}
