package com.usping.kdsn.product.controller;

import com.usping.kdsn.bean.Product;
import com.usping.kdsn.product.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by stan on 17-7-2.
 */

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    private final ProductServiceImpl productService;

    @Autowired
    public ProductRestController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @CrossOrigin
    @GetMapping("/product")
    public ResponseEntity<java.util.List<Product>> findAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

}
