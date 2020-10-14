package com.epam.booklibrary.dao.impl;

import com.epam.booklibrary.dao.BookDao;
import com.epam.booklibrary.dao.DaoException;
import com.epam.booklibrary.dao.DaoFactory;
import com.epam.booklibrary.entity.Book;
import com.epam.booklibrary.entity.Criteria;
import com.epam.booklibrary.entity.enums.SearchCriteria;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class BookDaoImplTest {

    @Test(expected = DaoException.class)
    public void sortByTagTest() throws DaoException{
        DaoFactory factory = DaoFactory.getInstance();
        BookDao bookDao = factory.getBookDao();
        Criteria criteria = new Criteria();
        bookDao.sortByTag(SearchCriteria.Book.TEST, bookDao.find(criteria));
    }

    @Test
    public void removeBookTest() throws DaoException{
        DaoFactory factory = DaoFactory.getInstance();
        BookDao bookDao = factory.getBookDao();
        Criteria criteria = new Criteria();
        List<Book> library = bookDao.find(criteria);
        Book newBook = new Book("\'Harry Potter and the Chamber of Secrets\'", "J.Rowling", "novel",
                "Bloomsbury Publishing", 1998);
        bookDao.removeBook(newBook, library);
        boolean result = (library.contains(newBook));
        Assert.assertEquals(result, false);
    }

    @Test
    public void addBookTest() throws DaoException{
        DaoFactory factory = DaoFactory.getInstance();
        BookDao bookDao = factory.getBookDao();
        Criteria criteria = new Criteria();
        List<Book> library = bookDao.find(criteria);
        Book newBook = new Book("\'Harry Potter and the Chamber of Secrets\'", "J.Rowling", "novel",
                "Bloomsbury Publishing", 1998);
        bookDao.addBook(newBook, library);
        boolean result = (library.contains(newBook));
        Assert.assertEquals(result, true);
    }

    @Test
    public void sortByTag() throws DaoException{
        DaoFactory factory = DaoFactory.getInstance();
        BookDao bookDao = factory.getBookDao();
        Criteria criteria = new Criteria();
        List<Book> library = bookDao.find(criteria);
        bookDao.sortByTag(SearchCriteria.Book.YEAROFPUBLICATION, library);
        Book firstBook = new Book("\'The Adventures of Tom Sawyer\'", "M.Twain", "story",
                "American Publishing Company", 1876);
        Book lastBook = new Book("\'Harry Potter and the Chamber of Secrets\'", "J.Rowling", "novel",
                "Bloomsbury Publishing", 1998);
        boolean first = library.get(0).equals(firstBook);
        boolean last = library.get(library.size()-1).equals(lastBook);
        Assert.assertTrue(first == last);
    }
}
