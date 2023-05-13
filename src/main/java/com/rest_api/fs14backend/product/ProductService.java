package com.rest_api.fs14backend.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteById(UUID id) {
        productRepository.deleteById(id);
    }

    public Product createOne(Product product) {

        return productRepository.save(product);
    }

    public Product updateOne(Product product) {
        Product productToUpdate = productRepository.findById(product.getId()).orElse(null);
        if (productToUpdate == null) {
            return null;
        }
        productToUpdate.setTitle(product.getTitle());
        productToUpdate.setIsAvailable(product.getIsAvailable());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setCreatedAt(product.getCreatedAt());
        productToUpdate.setModifiedAt(product.getModifiedAt());
        productToUpdate.setCategory(product.getCategory());
        return productRepository.save(productToUpdate);
    }
}
