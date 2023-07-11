package com.example.userservice.model.dto;

import com.example.userservice.model.entity.Product;
import lombok.Data;
import lombok.Getter;

@Getter
public class ProductReviewDTO {
    private Integer star;
    private String review;
}
