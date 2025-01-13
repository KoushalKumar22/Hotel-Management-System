package com.UserMicroServices.Registration_Service.Exceptions;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException(String message){
        super(message);
    }
}
