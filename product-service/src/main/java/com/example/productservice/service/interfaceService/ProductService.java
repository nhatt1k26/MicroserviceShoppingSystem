package com.example.productservice.service.interfaceService;

import com.example.productservice.model.dto.ProductRequest;
import com.example.productservice.model.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    boolean isEmpty();
    List<ProductResponse> findAll();
    ProductResponse findById(Long id);
    ProductResponse addProduct(ProductRequest newElement);
    ProductResponse updateProduct(Long id,ProductRequest updateElement);
    //    ProductResponse patchProduct(Long id, ProductPatch bookingOfficePatch);
    void deleteProduct(Long id);
}
