package com.scaler.productservicejune24.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//this says  that this class will be hosting a SET of HTTP API's(this annotation marks it as a  special class
//RC is a annotation that helps/allows  you to build http apis within this particular class
@RequestMapping("/say")//"/hello" is the address of this class is given by this annotation. if we write xyz.com/hello we will be able to reach out this sample controller
public class SampleController { // want  to call this method using url

   @GetMapping("/hello/{name}/{times}")//this annotation  is definie that this is a get method.{}-> this is path varibale
    public  String sayHello(@PathVariable("name") String name,@PathVariable("times") int times ){
       String output ="";
       for(int i=0;i<times;i++ ){
           output =output + "Hello"+name+" ";
       }
        return output ;
    }
    @GetMapping("/bye")
    public String sayBye(){
       return "Bye Everyone!";
    }
}
