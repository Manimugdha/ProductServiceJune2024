package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

//define all the methods that i need from  the service , getproduct etc ..
//all the methods of by default is public & static

public interface ProductService {
    Product getSingleProduct(Long productId);
    List<Product> getAllProducts();
}
