package com.rest_api.fs14backend.orders;

import com.rest_api.fs14backend.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private List<String> orderDetails;

    @Column(nullable = false)
    private String paymentType;

    @Column(nullable = false)
    private String shippingAddress;

    @Column(nullable = false)
    private String shippingMethod;

    @Column(nullable = false)
    private Integer shippingFee;

    @Column(nullable = false)
    private Integer total;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public UUID getUser() {
        return user.getId();
    }
}