package com.usping.kdsn.product.service;

import com.usping.kdsn.bean.Product;
import com.usping.kdsn.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> findAll() {
        return productMapper.selectAll();
    }
}
