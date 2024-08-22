package com.scaler.productservicejune24.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // this annotation means this models need to in DB , i.e a table for every model(Hibernate creates a table of the same name with the entity annotation )
public class Category extends BaseModel {
    private long id;
    private String name;
    private String description;
}
