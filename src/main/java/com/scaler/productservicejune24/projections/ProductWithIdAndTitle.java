package com.scaler.productservicejune24.projections;

public interface ProductWithIdAndTitle {

    //define the getter methods, & in product repo return with List<ProductwithIDandTitle>
    Long getId();
    String getTitle();

}
/*
if we wanted to 2 attribute from an object , not the complete obj , if we return the obj it will have
2 attribute will have values and other will be null which is not good so.
here comes the projections concept : sample model which we can use to get the output from the HQL
Projections : sample interfaces which only have  getter methods / getter of attributes that we are trying to fetch from DB
and hibernate will map the ouput of the HQL query with that interface
*/