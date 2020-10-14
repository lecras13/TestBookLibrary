package com.epam.booklibrary.dao;

import com.epam.booklibrary.dao.impl.BookDaoImpl;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private final BookDao bookDao = new BookDaoImpl();

    private DaoFactory(){
    }

    public BookDao getBookDao(){
        return bookDao;
    }

    public static DaoFactory getInstance(){
        return instance;
    }
}
