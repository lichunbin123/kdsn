package com.usping.kdsn.product.controller;

import com.usping.kdsn.bean.Product;
import com.usping.kdsn.product.service.ProductServiceImpl;
import com.usping.kdsn.util.model.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @CrossOrigin
    @GetMapping("/getProductForUser")
    public ResponseEntity<ResultMap> findProductForUser(Product product) {
        try {
            ResultMap resultMap;
            resultMap = productService.findProductForUser(product.getOffset(),product.getPageSize());
            if(resultMap.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
