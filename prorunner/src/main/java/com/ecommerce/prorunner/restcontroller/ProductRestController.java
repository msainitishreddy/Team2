package com.ecommerce.prorunner.restcontroller;

import com.ecommerce.prorunner.entity.ProductEntity;
import com.ecommerce.prorunner.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-api")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity productEntity){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(productEntity));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductEntity>> listOfProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.listOfProducts());
    }
}
