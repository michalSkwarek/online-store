package com.skwarek.onlineStore.domain.product.specifications;

import com.skwarek.onlineStore.domain.product.specifications.modules.*;

/**
 * Created by Michal on 27.09.2016.
 */
public class PCSpecifications extends ProductSpecifications {

    public PCSpecifications() {
        setCpu(new CPU());
        setGpu(new GPU());
        setRam(new RAM());
        setStorage(new Storage());
        setPowerSupply(new PowerSupply());
        setOs(new OS());
        setDimensions(new Dimensions());
        setWeight(new Weight());
    }
}
