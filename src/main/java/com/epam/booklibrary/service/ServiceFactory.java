package com.epam.booklibrary.service;

import com.epam.booklibrary.service.impl.BookServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final BookService bookService = new BookServiceImpl();

    private ServiceFactory(){
    }

    public BookService getBookService(){
        return bookService;
    }

    public static ServiceFactory getInstance(){
        return instance;
    }
}

