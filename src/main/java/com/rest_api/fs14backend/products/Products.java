package com.rest_api.fs14backend.products;

import com.rest_api.fs14backend.category.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "products")
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String name;

    @Column(nullable = false)
    private String variants;

    @Column(nullable = false)
    private String sizes;


    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String description;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String slug;

//    @ElementCollection
    @Column(nullable = false)
    private List<String> images;

    @Column(nullable = false, columnDefinition = "decimal")
    private Double price;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    @ManyToOne(optional = false)
    private Category category;

    public Products(
            String name,
            String sizes,
            Double price,
            String description,
            String slug,
            List<String> images,
            String variants,
            Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.slug = slug;
        this.images = images;
        this.sizes = sizes;
        this.variants = variants;
    }
}