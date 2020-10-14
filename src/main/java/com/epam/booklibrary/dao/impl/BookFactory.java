package com.epam.booklibrary.dao.impl;

import com.epam.booklibrary.entity.Book;
import com.epam.booklibrary.entity.enums.SearchCriteria;

import java.util.Map;

public class BookFactory {

    static Book newBook(Map<String, String> description){
        String title = description.get(SearchCriteria.Book.TITLE.toString());
        String author = description.get(SearchCriteria.Book.AUTHOR.toString());
        String genre = description.get(SearchCriteria.Book.GENRE.toString());
        String publisher = description.get(SearchCriteria.Book.PUBLISHER.toString());
        int yearOfPublication = Integer.parseInt(description.get(SearchCriteria.Book.YEAROFPUBLICATION.toString()));
        Book book = new Book(title, author, genre, publisher, yearOfPublication);
        return book;
    }
}
