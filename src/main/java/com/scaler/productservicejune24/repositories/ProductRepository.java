package com.scaler.productservicejune24.repositories;

import com.scaler.productservicejune24.models.Product;
import com.scaler.productservicejune24.projections.ProductWithIdAndTitle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
    Page<Product> findAll(Pageable pageable);

    //HQL : here we use name of the models , DB independent
    @Query("select p.id as id,p.title as title from Product p where p.id = :x ")//when we write this annotation spring/Jpa will not write this quuery on their on ,  we are looking to provide custom query for this mehtod.
   List<ProductWithIdAndTitle> randomSearchMethod(Long x);
    //SQL
    @Query(value = "select * from products p  where p.id = :productId",nativeQuery = true)
    Product randomSearchMethod2(Long productId);
}
/*
we will not be implementing methods on our own. we will use JPA repository .
JPA providesus an interface <<JPA repo>> and now if we want to make my product repo compatible with jpa repo we will have to do 2 things
1.Repo should be an interface.
2. Repository should extend JPA repo.
*/