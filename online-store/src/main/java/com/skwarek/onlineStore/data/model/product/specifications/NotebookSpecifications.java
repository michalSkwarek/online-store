package com.skwarek.onlineStore.data.model.product.specifications;

import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;
import com.skwarek.onlineStore.data.entity.product.specifications.modules.*;

/**
 * Created by Michal on 01.10.2016.
 */
public class NotebookSpecifications extends ProductSpecifications {

    public NotebookSpecifications() {
        setCpu(new CPU());
        setGpu(new GPU());
        setRam(new RAM());
        setStorage(new Storage());
        setDisplay(new Display());
        setBattery(new Battery());
        setOs(new OS());
        setWebcam(new Webcam());
        setDimensions(new Dimensions());
        setWeight(new Weight());
    }
}
