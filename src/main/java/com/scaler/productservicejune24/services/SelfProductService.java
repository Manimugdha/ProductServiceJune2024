package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.exceptions.ProductNotFoundException;
import com.scaler.productservicejune24.models.Category;
import com.scaler.productservicejune24.models.Product;
import com.scaler.productservicejune24.repositories.CategoryRepository;
import com.scaler.productservicejune24.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;// we are injecting the object in this reference since we cant create obj of interface
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        //Make a call to DB to fetch a product with given id.
        //optional is a kind of bucket if the object is present it will give otherwise throws the exception, but at first we mneed to check the bucket if the prduct obj is present or not.
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException("Product with id"+productId+" does not exist");
        }
         return productOptional.get();

    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);

    }

    @Override
    public Product addNewProduct(Product product) {
        //here we need to check the product object getting in the input parameter if it's category is already set or not ,if not it will throw error .
        //first we need to create a new  category
        Category category = product.getCategory();

        if (category.getId()== null) { //that means id is not set
            //we crete a new category object in the DB first.
            category = categoryRepository.save(category);
            product.setCategory(category);

        }
       return productRepository.save(product);
    }


}
