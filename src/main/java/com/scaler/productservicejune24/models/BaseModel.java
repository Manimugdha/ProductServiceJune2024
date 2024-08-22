package com.scaler.productservicejune24.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;


//to store the common attributes (instead od writing the common attributes again and again ) we will create a parent /base class
@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id // this is the primary key of all the child classes.
    @GeneratedValue(strategy = GenerationType.IDENTITY)// autoincrement of the primary key in DB
    private long id ;
    private Date createdAt;
    private Date updatedAt;
}
