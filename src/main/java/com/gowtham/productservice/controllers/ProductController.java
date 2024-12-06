package com.gowtham.productservice.controllers;

import com.gowtham.productservice.ProductServiceApplication;
import com.gowtham.productservice.dtos.*;
import com.gowtham.productservice.exceptions.NotFoundException;
import com.gowtham.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/products")
public class ProductController
{
    private ProductService productService;
    // Field injection
//    @Autowired
//    private ProductService productService;

    // Constructor injection
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService)
    {
        this.productService = productService;
    }

    // Setter injection
//    @Autowired
//    public void setProductService(ProductService productService)
//    {
//        this.productService = productService;
//    }
    @GetMapping
    public List<GenericProductDto> getAllProducts()
    {
        return this.productService.getAllProducts();
    }

    // localhost:8080/products/123
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException
    {
        return this.productService.getProductById(id);
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product)
    {
        return this.productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable Long id)
    {
        return ResponseEntity.accepted().body(this.productService.deleteProductById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericProductDto> updateProductById(@PathVariable("id") Long id, @RequestBody GenericProductDto product)
    {
        return ResponseEntity.accepted().body(this.productService.updateProductById(id, product));
    }
}
