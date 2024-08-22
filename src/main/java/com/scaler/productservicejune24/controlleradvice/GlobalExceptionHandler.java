package com.scaler.productservicejune24.controlleradvice;

import com.scaler.productservicejune24.dtos.ExceptionDto;
import com.scaler.productservicejune24.exceptions.ProductNotFoundException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    //here we write all the exception that need to be thrown

    @ExceptionHandler(ArithmeticException.class) // this method we want to execute when , for what type of exception ?  => Arithmatic.class type (type we define as . class)
    //if exception happens dont pass exception as it is to the client , execute the below code.
    //instead of sending single string message in response we can send more data like id ,product object or helper object to user what kind of object we should create ? ==> DTO
    public ResponseEntity<ExceptionDto> handleArithmeticException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Arithmetic exception has happened");
        exceptionDto.setSolutions("I don't know , please try again ");

        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                exceptionDto,
                HttpStatus.NOT_FOUND

        );
        return response;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public  ResponseEntity<String> handleArrayIndexOutOfBoundsException(){
        ResponseEntity<String>  response = new ResponseEntity<>(
                "Array Out of Bound",
                HttpStatus.BAD_REQUEST
        );
        return response;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public  ResponseEntity<ExceptionDto> handleProductNotFoundException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        //todo : pass the input id in the Exception
        exceptionDto.setMessage("Product not found");
        exceptionDto.setSolutions("Please try again with a valid product id  ");

        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                exceptionDto,
                HttpStatus.NOT_FOUND

        );
        return response;
//        @ExceptionHandler(ProductNotFoundException.class)
//        public ResponseEntity<ExceptionDto> handleProductNotFoundException() {
//            ExceptionDto exceptionDto = new ExceptionDto();
//            exceptionDto.setMessage("Product not found"); // Use the message from the exception
//            exceptionDto.setSolutions("Please try again with a valid product ID.");
//            exceptionDto.setProductId(getProductId()); // Set the product ID from the exception
//
//            return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
//        }

    }


}
