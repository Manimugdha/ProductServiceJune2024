package com.scaler.productservicejune24.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private  String title;
    private  Double price;
    @ManyToOne(cascade = CascadeType.PERSIST)//if we try to save product obj automatically save category obj
    private Category category;


}
