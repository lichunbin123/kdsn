package com.usping.kdsn.product.service;

import com.usping.kdsn.bean.Product;
import com.usping.kdsn.util.model.ResultMap;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    ResultMap findProductForUser(int start, int size);
}
