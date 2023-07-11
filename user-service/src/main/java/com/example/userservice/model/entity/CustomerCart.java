package com.example.userservice.model.entity;

import com.example.userservice.security.models.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    User user;
    @ManyToOne
    Product product;
    private Integer itemQuantity;

    public CustomerCart(User user, Product product, Integer itemQuantity) {
        this.user = user;
        this.product = product;
        this.itemQuantity = itemQuantity;
    }
}
