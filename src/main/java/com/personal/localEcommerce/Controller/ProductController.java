package com.personal.localEcommerce.Controller;


import com.personal.localEcommerce.Model.Product;
import com.personal.localEcommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/add-product/{storeId}")
    public ResponseEntity<Product> addProductByStore(@PathVariable long storeId, @RequestBody Product product){
        Product newProduct = productService.addProductByStore(storeId, product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }
}
