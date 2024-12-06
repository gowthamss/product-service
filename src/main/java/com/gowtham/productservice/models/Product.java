package com.gowtham.productservice.models;

import lombok.*;

@Setter
@Getter
public class Product
{
    private String title;
    private String description;
    private String image;
    private Category category;
    private double price;
}
