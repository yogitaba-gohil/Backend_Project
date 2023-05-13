package com.rest_api.fs14backend.product;
import com.rest_api.fs14backend.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> findAll() {

        return productService.findAll();
    }
    @GetMapping("/{id}")
    public Product findById(@PathVariable UUID id) {
        Product product = productService.findById(id);

        if (product == null) {
            throw new NotFoundException("Product not found");
        }
        return product;
    }

    @PostMapping
    public Product createOne(@RequestBody Product product) {
        return productService.createOne(product);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable UUID id) {
        productService.deleteById(id);
    }

    @PutMapping
    public Product updateOne(@RequestBody Product product) {
        return productService.updateOne(product);
    }
}