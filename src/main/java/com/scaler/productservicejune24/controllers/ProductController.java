package com.scaler.productservicejune24.controllers;

import com.scaler.productservicejune24.exceptions.ProductNotFoundException;
import com.scaler.productservicejune24.models.Product;
import com.scaler.productservicejune24.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ProductController(@Qualifier("selfProductService") //springboot will inject this bean with this name in this reference
                             ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {//along with product object we want to send the status code as well ( if we want to send response /status code  we will return ResponseEntity<Product>
       //inside the ResponseEntity object i want to send the product data

//        ResponseEntity<Product> responseEntity  = null;

        //handling exceptions

//        try {
//             Product product = productService.getSingleProduct(id);

//            responseEntity = new ResponseEntity<>(
//                    //instead of returning the object directly , we want to send the response entity so that in the responseEntity object we can also encapsulate more things .( product object and response code )
//                    product,  //product object
//                    HttpStatus.OK  // OK -> is the status code.
//
//                );
//         } catch (RuntimeException e) {
//            responseEntity = new ResponseEntity(
//                   HttpStatus.NOT_FOUND
//            );
//        }
        ResponseEntity<Product> response = new ResponseEntity<>(
                productService.getSingleProduct(id),
                HttpStatus.OK
        );

        return response;

    }
    @GetMapping()
    public Page<Product> getAllProducts(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize){
        return productService.getAllProducts(pageNumber,pageSize);//task : conevert this list of product into page of product
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long productId){
          productService.deleteProduct(productId);

    }

    //PATCH -> http:// localhost:8080/products/1 (update the product with id 1)
    @PatchMapping("/{id}")
    public  Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product) throws ProductNotFoundException {// ideally we should create DTO here,
        return  productService.updateProduct(id,product);
    }

     @PutMapping("/{id}")
    public  Product replaceProduct(@PathVariable("id") Long id,@RequestBody Product product){
     //put
         return null;

    }

    //this gets the 1st priority over the controller advice
//    @ExceptionHandler(ArithmeticException.class)
//    public  ResponseEntity<String> handleArithmeticException(){
//        ResponseEntity<String> response = new ResponseEntity<>("Arithmetic exception , inside the  controller", HttpStatus.BAD_REQUEST);
//
//        return  response;
//    }
     @PostMapping
    public Product addnewProduct(@RequestBody Product product){
        return productService.addNewProduct(product);
    }


}
