package com.epam.booklibrary;

import com.epam.booklibrary.entity.Book;
import com.epam.booklibrary.entity.Criteria;
import com.epam.booklibrary.entity.enums.SearchCriteria;
import com.epam.booklibrary.service.BookService;
import com.epam.booklibrary.service.ServiceException;
import com.epam.booklibrary.service.ServiceFactory;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws ServiceException{
        LOGGER.log(Level.INFO, "Creating factory and get accesses to DAO");
        ServiceFactory factory = ServiceFactory.getInstance();
        BookService service = factory.getBookService();

        LOGGER.log(Level.INFO, "Showing all library");
        Criteria criteria = new Criteria();
        PrintLibrary.print(service.find(criteria));

        LOGGER.log(Level.INFO, "Showing book with Tag(AUTHOR=S.King)");
        Criteria criteria1 = new Criteria();
        criteria1.add(SearchCriteria.Book.AUTHOR.toString(), "S.King");
        PrintLibrary.print(service.find(criteria1));

        LOGGER.log(Level.INFO, "Adding new book to library");
        Book newBook = new Book("\'1Harry Potter and the Chamber of Secrets\'", "J.Rowling", "novel",
                "Bloomsbury Publishing", 1998);
        service.addBook(newBook, service.find(criteria));
        PrintLibrary.print(service.find(criteria));

        LOGGER.log(Level.INFO, "Deleting book from library from previous adding");
        service.removeBook(newBook, service.find(criteria));
        PrintLibrary.print(service.find(criteria));

        LOGGER.log(Level.INFO, "Sorting library by Tag(YearOfPublication)");
        service.sortByTag(SearchCriteria.Book.YEAROFPUBLICATION, service.find(criteria));
        PrintLibrary.print(service.find(criteria));
    }
}
