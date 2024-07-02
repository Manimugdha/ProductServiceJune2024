package com.scaler.productservicejune24.models;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;


//to store the common attributes (instead od writing the common attributes again and again ) we will create a parent /base class
@Getter
@Setter
public class BaseModel {
    private long id ;
    private Date createdAt;
    private Date updatedAt;
}
