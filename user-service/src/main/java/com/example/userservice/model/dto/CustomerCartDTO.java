package com.example.userservice.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCartDTO {
    private Long productId;
    private Integer quantity;
}
