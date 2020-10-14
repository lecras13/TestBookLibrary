package com.epam.booklibrary.service;

import com.epam.booklibrary.entity.Book;
import com.epam.booklibrary.entity.Criteria;
import com.epam.booklibrary.entity.enums.SearchCriteria;

import java.util.List;

public interface BookService {
    List<Book> find(Criteria criteria) throws ServiceException;

    void addBook(Book newBook, List<Book> library) throws ServiceException;

    void removeBook(Book newBook, List<Book> library) throws ServiceException;

    void sortByTag(SearchCriteria.Book searchCriteria, List<Book> library) throws ServiceException;
}