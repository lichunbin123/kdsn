package com.usping.kdsn.product.controller;

import com.usping.kdsn.bean.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author ning on 18-3-5.
 * @project kdsn
 */
@RestController
@RequestMapping("/api/product/")
public class ProductRestController {

    private static Logger logger = LoggerFactory.getLogger(ProductRestController.class);

    /**
     * use for test access
     * @return
     */
    @CrossOrigin
    @GetMapping("test")
    public ResponseEntity<String> testConnection() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("product")
    public ResponseEntity<?> add(@RequestBody Transaction transaction) {

        // TODO: 18-3-6 with full insert
        logger.info(transaction.toString());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
