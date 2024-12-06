package com.gowtham.productservice.dtos;

import com.gowtham.productservice.models.Category;
import lombok.*;

@Setter
@Getter
public class GenericProductDto
{
    private Long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;
}
