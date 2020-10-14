package com.epam.booklibrary;

import com.epam.booklibrary.entity.Book;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

public class PrintLibrary {
    private static final Logger LOGGER = Logger.getLogger(PrintLibrary.class.getName());

    public static void print(List<Book> library){
        if (library.isEmpty()) {
            LOGGER.log(Level.INFO, "По запросу ничего не найдено");
        } else {
            for (Book book : library) {
                LOGGER.log(Level.INFO, book.toString());
            }
        }
    }
}
