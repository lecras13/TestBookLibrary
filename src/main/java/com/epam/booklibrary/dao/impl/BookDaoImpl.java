package com.epam.booklibrary.dao.impl;

import com.epam.booklibrary.dao.BookDao;
import com.epam.booklibrary.dao.DaoException;
import com.epam.booklibrary.entity.Book;
import com.epam.booklibrary.entity.Criteria;
import com.epam.booklibrary.entity.enums.SearchCriteria;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;


public class BookDaoImpl implements BookDao {
    private static final String FILEPATH = "src/main/resources/book_db.txt";
    private static final Logger LOGGER = Logger.getLogger(BookDaoImpl.class.getName());

    @Override
    public List<Book> find(Criteria criteria) throws DaoException{
        LOGGER.log(Level.INFO, "FINDING LIBRARY");
        List<Book> findBook = new ArrayList<Book>();
        Map<String, String> parametres;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
            String line;
            while ((line = reader.readLine()) != null) {
                parametres = fillCriteria(line);
                if (compareCriteria(parametres, criteria.getCriteria())) {
                    findBook.add(BookFactory.newBook(parametres));
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new DaoException(e);
        }
        return findBook;
    }

    @Override
    public void addBook(Book newBook, List<Book> library) throws DaoException{
        LOGGER.log(Level.INFO, "ADDING A BOOK");
        List<Book> libraryWithNewBook = addBookToList(newBook, library);
        reWriteLibrary(libraryWithNewBook, true);
    }

    @Override
    public void removeBook(Book newBook, List<Book> library) throws DaoException{
        LOGGER.log(Level.INFO, "REMOVING A BOOK");
        List<Book> libraryWithOutNewBook = removeBookFromList(newBook, library);
        reWriteLibrary(libraryWithOutNewBook, false);
    }

    @Override
    public void sortByTag(SearchCriteria.Book searchCriteria, List<Book> library) throws DaoException{
        LOGGER.log(Level.INFO, "SORTING BY TAG");
        chooseTagForSort(searchCriteria, library);
        reWriteLibrary(library, false);
    }

    private Map<String, String> fillCriteria(String data){
        Map<String, String> fillCriteria = new HashMap<String, String>();
        String[] s = data.split("\\s?,\\s");
        for (int i = 0; i < s.length; i++) {
            fillCriteria.put(s[i].split("=")[0], s[i].split("=")[1]);
        }
        return fillCriteria;
    }

    private void chooseTagForSort(SearchCriteria.Book searchCriteria, List<Book> library) throws DaoException{
        switch (searchCriteria.toString()) {
            case "TITLE":
                Collections.sort(library, Book.Comparators.TITLE);
                break;
            case "AUTHOR":
                Collections.sort(library, Book.Comparators.AUTHOR);
                break;
            case "GENRE":
                Collections.sort(library, Book.Comparators.GENRE);
                break;
            case "PUBLISHER":
                Collections.sort(library, Book.Comparators.PUBLISHER);
                break;
            case "YEAROFPUBLICATION":
                Collections.sort(library, Book.Comparators.YEAROFPUBLICATION);
                break;
            default:
                throw new DaoException("Wrong criteria!");
        }
    }

    private boolean compareCriteria(Map<String, String> parametres, Map<String, String> criteria){
        boolean isParam = true;
        for (Map.Entry<String, String> entry : criteria.entrySet()) {
            String st = entry.getKey();
            if (!("" + criteria.get(st)).equals(parametres.get(st))) {
                isParam = false;
            }
        }
        return isParam;
    }

    private List<Book> addBookToList(Book newBook, List<Book> library) throws DaoException{
        List<Book> libraryWithNewBook = new ArrayList<>();
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).equals(newBook)) {
                throw new DaoException("This book exists!");
            } else if ((library.get(i).equals(newBook)) && (i == (library.size() - 1))) {
                libraryWithNewBook.add(newBook);
                break;
            }
        }
        return libraryWithNewBook;
    }

    private List<Book> removeBookFromList(Book newBook, List<Book> library) throws DaoException{
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).equals(newBook)) {
                library.remove(i);
                break;
            }
        }
        return library;
    }

    private void reWriteLibrary(List<Book> library, boolean appendMarker) throws DaoException{
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(FILEPATH, appendMarker));
            for (Book str : library) {
                String strForWrite = str.toString();
                writer.write(strForWrite);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new DaoException(e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

