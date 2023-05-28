package com.rest_api.fs14backend.products;

import java.util.List;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class ProductDTO {
    private UUID categoryId;
    private String name;
    private String sizes;
    private Double price;
    private int quantity;
    private String description;
    private String slug;
    private List<String> images;
    private  String variants;
}