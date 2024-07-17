package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.dtos.FakeStoreProductDto;
import com.scaler.productservicejune24.models.Category;
import com.scaler.productservicejune24.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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
                "https://fakestoreapi.com/products/" + productId, //call this url and whatever data is returning convert the output into this type( ie FakestrePrdDto.clss)
                FakeStoreProductDto.class// we have manually replicated the output of the url in dto class
        );
        //convert fakeStoreProductDto into Product (
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);

    }


    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(
               "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class//type eraser


        );
        //convert list of fakestoredto to list of product
        List<Product> products = new ArrayList<>();

        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }

        return products;
    }

    /*  << this is the format of the updateProduct method>>
       RequestCallback requestCallback = this.httpEntityCallback(requestBody , responseType);
        HttpMessageConverterExtractor<T> responseExtractor = new HttpMessageConverterExtractor(responseType, this.getMessageConverters(), this.logger);
        return this.execute(url, HttpMethod.PATCH, requestCallback, responseExtractor, (Object[])uriVariables);
    */
    //Partial update
    @Override
    public Product updateProduct(Long id, Product product) {
        //PATCH=> return type is void and we need product as return type..so go inside the wrapper class put and check its internal methods and we found .execute method is been repeatedly used
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product,FakeStoreProductDto.class);//replace this by restTeMplate object cuz it belongs to RestTemplace class// type of the object is written by .class
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class,
                restTemplate.getMessageConverters());

        FakeStoreProductDto response = restTemplate.execute("https://fakestoreapi.com/product"+ id,
                HttpMethod.PATCH, requestCallback, responseExtractor);

        //comvert fakestoredto into product
        return  convertFakeStoreProductDtoToProduct(response);
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }

    //convert FakeStoreProductDto into Product(we will use this methods as its will be repeatedly use )
    private  Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getCategory());

        product.setCategory(category);

        return product;

    }
}
