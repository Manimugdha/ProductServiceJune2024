package com.scaler.productservicejune24.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//this class will be exactly similar to data that we are getting from fakestore , replica of the output of the api call
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

}
