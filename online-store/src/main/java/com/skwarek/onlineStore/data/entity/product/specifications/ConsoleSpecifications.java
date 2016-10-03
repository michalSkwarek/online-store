package com.skwarek.onlineStore.data.entity.product.specifications;

import com.skwarek.onlineStore.data.entity.product.specifications.modules.*;

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
