package com.scaler.productservicejune24.dtos;

import com.scaler.productservicejune24.controllers.ProductController;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//instead of sending single string message in response we can send more data like id ,product object or helper object to user what kind of object we should create ? ==> DTO
 public class ExceptionDto  {
    private  String message;
    private String solutions;

 }
