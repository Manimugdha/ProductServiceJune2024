package com.scaler.productservicejune24.inheritancetypes.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // in this case the, it will not create a table for this ,  but store the attributes of the child class in the table
//attributes will be the col name
@DiscriminatorValue(value = "3")
public class Instructor extends User {
    private  String subject;
    
}
