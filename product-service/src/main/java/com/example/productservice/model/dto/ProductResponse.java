package com.example.productservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String productName;
    private Float price;
    private String description;
    private Integer quantity;
//    @JsonIgnoreProperties(value = {"product"})
//    private List<ProductReview> productReviewList;
}

