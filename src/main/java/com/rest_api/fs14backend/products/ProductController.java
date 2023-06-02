package com.rest_api.fs14backend.products;

import com.rest_api.fs14backend.category.Category;
import com.rest_api.fs14backend.category.CategoryService;
import com.rest_api.fs14backend.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = {"http://127.0.0.1:5173", "https://front-end-project-liart.vercel.app"})
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private  ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductMapper productMapper;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Products> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable UUID id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ResponseEntity<Products> createProduct(@RequestBody ProductDTO productDTO) {
        UUID categoryId = productDTO.getCategoryId();
        Category category = categoryService.findById(categoryId);
        Products product = productMapper.toProduct(productDTO, category);
        return productService.createProduct(product);
    }

    @PutMapping
    public Products updateProduct(@RequestBody Products products) {
        return productService.updateProduct(products);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        return productService.deleteProduct(id);
    }
}