package com.skwarek.onlineStore.domain.product.specifications;

import com.skwarek.onlineStore.domain.product.specifications.modules.Weight;

/**
 * Created by Michal on 27.09.2016.
 */
public class ConsoleSpecifications extends ProductSpecifications {

    public ConsoleSpecifications() {
        setWeight(new Weight());
    }
}
