package com.gowtham.productservice.thirdpartyclients.productservice;

import com.gowtham.productservice.dtos.*;
import com.gowtham.productservice.exceptions.NotFoundException;
import com.gowtham.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductDto;

import java.util.List;

public interface ThirdPartyProductServiceClient
{
    FakeStoreProductDto getProductById(Long id) throws NotFoundException;

    FakeStoreProductDto createProduct(GenericProductDto product);
    List<FakeStoreProductDto> getAllProducts();

    FakeStoreProductDto updateProductById(Long id, GenericProductDto product);

    FakeStoreProductDto deleteProductById(Long id);
}
