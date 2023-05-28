package com.rest_api.fs14backend.products;

import com.rest_api.fs14backend.category.Category;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Products toProduct(ProductDTO product, Category category) {
        return new Products(
                product.getName(),
                product.getSizes(),
                product.getPrice(),
                product.getDescription(),
                product.getSlug(),
                product.getImages(),
                product.getVariants(),
                category);
    }
}