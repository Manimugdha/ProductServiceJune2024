package com.scaler.productservicejune24.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity // this annotation means this models need to in DB , i.e a table for every model(Hibernate creates a table of the same name with the
public class Category extends BaseModel {
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)// this relation is already define in product ,DB will one have this relation only once(mapped by means dont want to persist this change in DB)
    private List<Product> products;// from category i want to get product
}
