package com.rest_api.fs14backend.address;

import com.rest_api.fs14backend.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String address;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String city;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String postalCode;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String country;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;


}
