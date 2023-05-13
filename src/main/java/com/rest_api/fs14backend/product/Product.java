package com.rest_api.fs14backend.product;

import com.rest_api.fs14backend.category.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity(name = "product")
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String title;

    @Column(nullable = false)
    private Boolean isAvailable;

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