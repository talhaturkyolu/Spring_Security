package com.cybertek.controller;

import com.cybertek.entity.Product;
import com.cybertek.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    public Product getProduct(@PathVariable("id") Long id){
        return productService.getProduct(id);
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

   @PostMapping
    public List<Product> createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @DeleteMapping(value = "/{id}")
    public List<Product> deleteProduct(@PathVariable("id") Long id){
      return productService.delete(id);
    }

    @PutMapping (value = "/{id}")
    public List<Product> updateProduct(@PathVariable("id") Long id,@RequestBody Product product){
        return productService.updateProduct(id,product);
    }


}
