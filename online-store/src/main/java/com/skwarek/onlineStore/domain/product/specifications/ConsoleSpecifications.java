package com.skwarek.onlineStore.domain.product.specifications;

import com.skwarek.onlineStore.domain.product.specifications.modules.*;

/**
 * Created by Michal on 27.09.2016.
 */
public class ConsoleSpecifications extends ProductSpecifications {

    public ConsoleSpecifications() {
        setCpu(new CPU());
        setGpu(new GPU());
        setRam(new RAM());
        setStorage(new Storage());
        setDimensions(new Dimensions());
        setWeight(new Weight());
    }
}
