package com.epam.booklibrary.dao;

public class DaoException extends Exception {

    public DaoException(Exception e){
       super(e);
    }

    public DaoException(String message){
        super(message);
    }
}
