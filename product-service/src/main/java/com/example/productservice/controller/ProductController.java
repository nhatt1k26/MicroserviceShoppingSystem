package com.example.productservice.controller;


import com.example.productservice.model.dto.ProductRequest;
import com.example.productservice.model.dto.ProductResponse;
import com.example.productservice.service.interfaceService.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;
    private final ModelMapper modelMapper;


    @GetMapping("/all")
//    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findAllProduct(){
        logger.info("Find all product is call!");
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findProduct(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> addProduct(
            @RequestBody ProductRequest newProduct
    )
    {
        productService.addProduct(newProduct);
        return new ResponseEntity<>("Add new product successful", HttpStatus.CREATED);
    }




    @PutMapping("/updateProduct/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductRequest newProduct
    )
    {
        productService.updateProduct(id,newProduct);
        return new ResponseEntity<>("Update new product successful", HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteById(
            @PathVariable Long id
    )
    {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Deleted product",HttpStatus.OK);
    }
}
