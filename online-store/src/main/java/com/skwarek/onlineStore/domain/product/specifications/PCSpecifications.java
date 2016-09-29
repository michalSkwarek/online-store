package com.skwarek.onlineStore.domain.product.specifications;

import com.skwarek.onlineStore.domain.product.specifications.modules.*;

/**
 * Created by Michal on 27.09.2016.
 */
public class PCSpecifications extends ProductSpecifications {

    public PCSpecifications() {
        setPowerSupply(new PowerSupply());
        setOs(new OS());
        setWeight(new Weight());
    }
}
