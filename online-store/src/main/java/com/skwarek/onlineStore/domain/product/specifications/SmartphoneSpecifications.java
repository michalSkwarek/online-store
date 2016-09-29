package com.skwarek.onlineStore.domain.product.specifications;

import com.skwarek.onlineStore.domain.product.specifications.modules.Battery;
import com.skwarek.onlineStore.domain.product.specifications.modules.Display;
import com.skwarek.onlineStore.domain.product.specifications.modules.OS;
import com.skwarek.onlineStore.domain.product.specifications.modules.Weight;

/**
 * Created by Michal on 27.09.2016.
 */
public class SmartphoneSpecifications extends ProductSpecifications {

    public SmartphoneSpecifications() {
        setDisplay(new Display());
        setBattery(new Battery());
        setOs(new OS());
        setWeight(new Weight());
    }
}
