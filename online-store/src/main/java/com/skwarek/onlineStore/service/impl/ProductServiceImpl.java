package com.skwarek.onlineStore.service.impl;

import com.skwarek.onlineStore.domain.product.Product;
import com.skwarek.onlineStore.service.ProductService;
import com.skwarek.onlineStore.service.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by Michal on 26.09.2016.
 */
@Service("productService")
public class ProductServiceImpl extends GenericServiceImpl<Product, Long> implements ProductService {

}
