package com.epam.booklibrary.service.impl;

import com.epam.booklibrary.dao.BookDao;
import com.epam.booklibrary.dao.DaoFactory;
import com.epam.booklibrary.entity.Book;
import com.epam.booklibrary.entity.Criteria;
import com.epam.booklibrary.entity.enums.SearchCriteria;
import com.epam.booklibrary.service.BookService;
import com.epam.booklibrary.service.ServiceException;

import java.util.List;

public class BookServiceImpl implements BookService {

	@Override
    public List<Book> find(Criteria criteria) throws ServiceException{
        DaoFactory factory = DaoFactory.getInstance();
        BookDao bookDao = factory.getBookDao();

        List<Book> library;
        try {
            library = bookDao.find(criteria);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
        return library;
    }

    @Override
    public void addBook(Book newBook, List<Book> library) throws ServiceException{
        DaoFactory factory = DaoFactory.getInstance();
        BookDao bookDao = factory.getBookDao();
        try {
            bookDao.addBook(newBook, library);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void removeBook(Book newBook, List<Book> library) throws ServiceException{
        DaoFactory factory = DaoFactory.getInstance();
        BookDao bookDao = factory.getBookDao();
        try {
            bookDao.removeBook(newBook, library);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void sortByTag(SearchCriteria.Book searchCriteria, List<Book> library) throws ServiceException{
        DaoFactory factory = DaoFactory.getInstance();
        BookDao bookDao = factory.getBookDao();
        try {
            bookDao.sortByTag(searchCriteria, library);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
