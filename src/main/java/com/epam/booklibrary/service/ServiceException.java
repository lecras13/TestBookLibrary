package com.epam.booklibrary.service;


public class ServiceException extends Exception {

    public ServiceException(Exception e){
        super(e);
    }
}