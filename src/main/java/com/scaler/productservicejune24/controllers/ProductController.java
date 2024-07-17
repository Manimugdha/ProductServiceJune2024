package com.scaler.productservicejune24.controllers;

import com.scaler.productservicejune24.models.Product;
import com.scaler.productservicejune24.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    //instead of directly depending on fakestoreproduct service we are creating an interface productservice .if tommor
    private ProductService productService; // this is the reference 
    /* we cant create a object of an interface (because interfaces are incomplete it cannot be initialised)
    Spring fw will try to find the objects of its implementation , that has developer created any implementation of product service interface
    ie. fakestoreproductservice implements <<productservice>>, now the spring fw will try to find
    how will in we inject the object of this : using dependency injection
    
     */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
      return  productService.getSingleProduct(id);

    }
    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    public void deleteProduct(Long productId){

    }
    //PATCH -> http:// localhost:8080/products/1 (update the product with id 1)
    @PatchMapping("/{id}")
    public  Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product){// ideally we should create DTO here
        return  productService.updateProduct(id,product);
    }
     @PutMapping("/{id}")
    public  Product replaceProduct(@PathVariable("id") Long id,@RequestBody Product product){
     //put
         return null;

    }



}
