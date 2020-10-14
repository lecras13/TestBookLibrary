package com.epam.booklibrary.dao;

import com.epam.booklibrary.entity.Book;
import com.epam.booklibrary.entity.Criteria;
import com.epam.booklibrary.entity.enums.SearchCriteria;

import java.util.List;

public interface BookDao {
    List<Book> find(Criteria criteria) throws DaoException;

    void addBook(Book newBook, List<Book> library) throws DaoException;

    void removeBook(Book newBook, List<Book> library) throws DaoException;

    void sortByTag(SearchCriteria.Book searchCriteria, List<Book> library) throws DaoException;
}
