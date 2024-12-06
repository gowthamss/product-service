package com.gowtham.productservice.services;

import com.gowtham.productservice.dtos.*;
import com.gowtham.productservice.exceptions.NotFoundException;
import com.gowtham.productservice.thirdpartyclients.productservice.fakestore.*;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService
{
    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient)
    {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    private GenericProductDto convertFakeStoreProductToGenericProduct(FakeStoreProductDto fakeStoreProductDto)
    {
        GenericProductDto product = new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());
        return product;
    }
    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException
    {
        return convertFakeStoreProductToGenericProduct(this.fakeStoreProductServiceClient.getProductById(id));
    }

    /*
        Don't implement the logic of FakeStore in your service.
        Implement only your own logic inside services and delegate the client logic into its own.
        Here, below createProduct by calling FakeStore client is the only sole responsibility of this service. But not to implement that logic.
        The FakeStore client just calls fake store and returns response and we perform some business logic on top of it.
     */
    @Override
    public GenericProductDto createProduct(GenericProductDto product)
    {
        return convertFakeStoreProductToGenericProduct(this.fakeStoreProductServiceClient.createProduct(product));
    }

    @Override
    public List<GenericProductDto> getAllProducts()
    {
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : this.fakeStoreProductServiceClient.getAllProducts()) {
            genericProductDtos.add(convertFakeStoreProductToGenericProduct(fakeStoreProductDto));
        }

        return genericProductDtos;
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto product)
    {
        return convertFakeStoreProductToGenericProduct(this.fakeStoreProductServiceClient.updateProductById(id, product));
    }

    @Override
    public GenericProductDto deleteProductById(Long id)
    {
        return convertFakeStoreProductToGenericProduct(this.fakeStoreProductServiceClient.deleteProductById(id));
    }
}
