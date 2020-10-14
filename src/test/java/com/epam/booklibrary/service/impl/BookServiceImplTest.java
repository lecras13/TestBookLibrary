package com.epam.booklibrary.service.impl;

import com.epam.booklibrary.entity.Book;
import com.epam.booklibrary.entity.Criteria;
import com.epam.booklibrary.entity.enums.SearchCriteria;
import com.epam.booklibrary.service.BookService;
import com.epam.booklibrary.service.ServiceException;
import com.epam.booklibrary.service.ServiceFactory;
import org.junit.Test;

import java.util.List;

public class BookServiceImplTest {
    @Test(expected = ServiceException.class)
    public void findAndSortServiceTest() throws ServiceException{
       ServiceFactory serviceFactory =  ServiceFactory.getInstance();
       BookService bookService  = serviceFactory.getBookService();
       Criteria criteria = new Criteria();
       bookService.sortByTag(SearchCriteria.Book.TEST, bookService.find(criteria));
    }

    @Test(expected = ServiceException.class)
    public void removeBookServiceTest() throws ServiceException{
        ServiceFactory serviceFactory =  ServiceFactory.getInstance();
        BookService bookService  = serviceFactory.getBookService();
        Criteria criteria = new Criteria();
        List<Book> library = bookService.find(criteria);
        Book newBook = new Book("\'Harry Potter and the Chamber of Secrets\'", "J.Rowling", "novel",
                "Bloomsbury Publishing", 1998);
        bookService.removeBook(newBook, library);
    }

    @Test(expected = ServiceException.class)
    public void addBookServiceTest() throws ServiceException{
        ServiceFactory serviceFactory =  ServiceFactory.getInstance();
        BookService bookService  = serviceFactory.getBookService();
        Criteria criteria = new Criteria();
        List<Book> library = bookService.find(criteria);
        Book newBook = new Book("\'Harry Potter and the Chamber of Secrets\'", "J.Rowling", "novel",
                "Bloomsbury Publishing", 1998);
        bookService.addBook(newBook, library);
    }
}
