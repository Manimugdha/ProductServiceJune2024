package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.dtos.FakeStoreProductDto;
import com.scaler.productservicejune24.models.Category;
import com.scaler.productservicejune24.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    public  FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;

    }

    @Override
    public Product getSingleProduct(Long productId) {
        //call fakestore  service to fetch the product with given id .=> HTTP call.(multiple ways to make an http call )
        //one of the most widely used is REST TEMPLATE ( its a class) which allow us to   https call to 3rd party system.
         //RestTemplate restTemplate = new RestTemplate();

        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId, //call this url and whatever data is returning convert the output into this type( ie FakestrePrd.clss)
                FakeStoreProductDto.class// we have manually replicated the output of the url in dto class
        );
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);

    }
    private  Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        //convert FakeStoreProductDto into Product
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getCategory());

        product.setCategory(category);

        return product;

    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
