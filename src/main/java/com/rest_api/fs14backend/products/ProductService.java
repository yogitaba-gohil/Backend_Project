package com.rest_api.fs14backend.products;

import com.rest_api.fs14backend.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Products> getProducts() {
        return productRepository.findAll();
    }

    public ResponseEntity<List<Products>> getProductsByIds(List<UUID> ids) {
        List<Products> products = productRepository.findProductsByIdIn(ids);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    public ResponseEntity<Products> getProductById(UUID id) {
        if (!productRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            Optional<Products> product = productRepository.findById(id);
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Products> createProduct(Products products) {
        productRepository.save(products);
        return new ResponseEntity<>(products, HttpStatus.CREATED);
    }



    public Products updateProduct(Products products) {
        Products productToUpdate = productRepository.findById(products.getId()).orElseThrow(() -> new NotFoundException("product is not exist"));

        if (productToUpdate == null) {
            return null;
        }
        productToUpdate.setName(products.getName());
        productToUpdate.setDescription(productToUpdate.getDescription());
        productToUpdate.setSlug(productToUpdate.getSlug());
        productToUpdate.setCategory(productToUpdate.getCategory());
        productToUpdate.setImages(products.getImages());
        productToUpdate.setVariants(products.getVariants());
        productToUpdate.setSizes(products.getSizes());
        productToUpdate.setPrice(products.getPrice());
        return productRepository.save(productToUpdate);
    }

    public ResponseEntity<Void> deleteProduct(UUID id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
