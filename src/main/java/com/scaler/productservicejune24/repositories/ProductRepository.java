package com.scaler.productservicejune24.repositories;

import com.scaler.productservicejune24.models.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository <Product,Long> {// < generic input( ie which model i want to intake , and DT of the primary key of this product table>
    //product repo should contain all methods (CRUD)   related to Product model.


    //Product findById(Long id); if the particular id is not present we will get null pointer exception
    //so we take the return type as optional of product
    //Product p = productRepository.findById(100); == null
    //String title = p.getTitle(); == npe

    Optional<Product> findProductsById(Long id);

    @Override
    List<Product> findAll(Sort sort);
}
/*
we will not be implementing methods on our own. we will use JPA repository .
JPA providesus an interface <<JPA repo>> and now if we want to make my product repo compatible with jpa repo we will have to do 2 things
1.Repo should be an interface.
2. Repository should extend JPA repo.
*/