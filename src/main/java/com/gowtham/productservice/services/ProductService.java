package com.gowtham.productservice.services;

import com.gowtham.productservice.dtos.*;
import com.gowtham.productservice.exceptions.NotFoundException;
import com.gowtham.productservice.models.Product;

import java.util.List;

public interface ProductService
{
    GenericProductDto getProductById(Long id) throws NotFoundException;

    GenericProductDto createProduct(GenericProductDto product);
    List<GenericProductDto> getAllProducts();

    GenericProductDto updateProductById(Long id, GenericProductDto product);

    GenericProductDto deleteProductById(Long id);
}
