package com.scaler.productservicejune24.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//class where we define bean  methods is called configuration class. @configuration
@Configuration//@cofig means that this class will have bean methods .This class will have to go through that class and execute all the @bean methods
public class ApplicationConfig {

    //this method will be creating an object of resttemplate.

    @Bean//spring will only create 1 object , we cant create  another object if we  use @bean annotation .
    //have u asked spring to execute the methods of this class/ marked as a special class? no , give @configuration
    //now spring will automatically create an object of this, if we want to use this object in your class we will need to autowire/inject it .
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
