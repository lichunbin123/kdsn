package com.usping.kdsn.product.service;

import com.usping.kdsn.bean.Product;
import com.usping.kdsn.mapper.ProductMapper;
import com.usping.kdsn.util.model.ResultMap;
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

    @Override
    public ResultMap findProductForUser(int start, int size) {
        return new ResultMap().setData(productMapper.selectProductForUser(start, size)).setTotal(productMapper.countProductForUser());
    }
}
