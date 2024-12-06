package com.gowtham.productservice.services;

import com.gowtham.productservice.dtos.*;
import com.gowtham.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService
{
    @Override
    public GenericProductDto getProductById(Long id)
    {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product)
    {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts()
    {
        return null;
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto product)
    {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(Long id)
    {
        return null;
    }
}
