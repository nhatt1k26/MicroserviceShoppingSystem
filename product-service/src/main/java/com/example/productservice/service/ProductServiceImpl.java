package com.example.productservice.service;

import com.example.productservice.model.dto.ProductRequest;
import com.example.productservice.model.dto.ProductResponse;
import com.example.productservice.model.entity.Product;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.service.interfaceService.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean isEmpty() {
        return productRepository.findAll().isEmpty();
    }

    @Override
    public List<ProductResponse> findAll() {

        return productRepository.findAll().stream().map(product-> modelMapper.map(product,ProductResponse.class)).collect(Collectors.toList());
    }


    @Override
    public ProductResponse findById(Long id) {
        return modelMapper.map(productRepository.findById(id).orElseThrow(()->{
            throw new EntityNotFoundException("product with id = "+ id + " not exist");
        }), ProductResponse.class);
    }

    @Override
    public ProductResponse addProduct(ProductRequest productDTO){
        Product productToAdd = modelMapper.map(productDTO,Product.class);
        return modelMapper.map(productRepository.save(productToAdd),ProductResponse.class);
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest productDTO){
        Product productToUpdate = modelMapper.map(productDTO, Product.class);
        productToUpdate.setId(id);
        // productToUpdate.setTrip(trip);
        return modelMapper.map(productRepository.save(productToUpdate), ProductResponse.class);
    }
//    @Override
//    public ProductResponse patchProduct(Long id, ProductPatch productPatch){
//        Product productToUpdate = modelMapper.map(productPatch, Product.class);
//        productToUpdate.setOfficeId(id);
//        // productToUpdate.setTrip(trip);
//        return modelMapper.map(productRepository.save(productToUpdate), ProductResponse.class);
//    }

    @Override
    public void deleteProduct(Long id){
        if (!productRepository.existsById(id))
            throw new EntityNotFoundException("Product with id = "+id+" not existed");
        productRepository.deleteById(id);
    }
}
