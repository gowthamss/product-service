package com.gowtham.productservice.thirdpartyclients.productservice.fakestore;

import com.gowtham.productservice.dtos.*;
import com.gowtham.productservice.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.*;

import java.util.*;

@Service
public class FakeStoreProductServiceClient
{
    private RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.url}")
    private String fakeStoreApiUrl;

    @Value("${fakestore.api.paths.products}")
    private String fakeStoreProductsApiPath;
    private String getProductRequestUrl;
    private String specificProductRequesBaseUrl;

    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder,
        @Value("${fakestore.api.url}") String fakeStoreApiUrl,
        @Value("${fakestore.api.paths.products}")String fakeStoreProductsApiPath)
    {
        this.restTemplateBuilder = restTemplateBuilder;
        this.getProductRequestUrl = fakeStoreApiUrl + fakeStoreProductsApiPath + "/{id}";
        this.specificProductRequesBaseUrl = fakeStoreApiUrl + fakeStoreProductsApiPath;
    }

    public FakeStoreProductDto getProductById(Long id) throws NotFoundException
    {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto>
            responseEntity = restTemplate.getForEntity(getProductRequestUrl, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

//        if (fakeStoreProductDto == null)
//        {
//            throw new NotFoundException("The product with id " + id + " is not found");
//        }
        return fakeStoreProductDto;
    }

    public FakeStoreProductDto createProduct(GenericProductDto product)
    {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(specificProductRequesBaseUrl, product, FakeStoreProductDto.class);
        return response.getBody();
    }

    public List<FakeStoreProductDto> getAllProducts()
    {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(specificProductRequesBaseUrl, FakeStoreProductDto[].class);
        List<FakeStoreProductDto> lgpd = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : response.getBody())
        {
            lgpd.add(fakeStoreProductDto);
        }
        return lgpd;
    }

    public FakeStoreProductDto updateProductById(Long id, GenericProductDto product)
    {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(getProductRequestUrl, HttpMethod.PUT, requestCallback, responseExtractor, id);
        return response.getBody();
    }

    public FakeStoreProductDto deleteProductById(Long id)
    {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(getProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        return response.getBody();
    }
}
