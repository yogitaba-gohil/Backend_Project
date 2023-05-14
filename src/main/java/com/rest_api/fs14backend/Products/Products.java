package com.rest_api.fs14backend.Products;

import com.rest_api.fs14backend.category.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
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

    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String title;

    @Column(nullable = false)
    private Boolean isAvailable;

    @Column(nullable = false)
    private String variants;

    @Column(nullable = false)
    private String sizes;


    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String description;

    @Column(columnDefinition = "varchar(50)")
    private String imageUrl;

    @Column(nullable = false, columnDefinition = "decimal")
    private Double price;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    @ManyToOne(optional = false)
    private Category category;
}