package com.epam.booklibrary.entity;

import java.util.Comparator;
import java.util.Objects;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private String genre;
    private String publisher;
    private int yearOfPublication;

    public Book(String title, String author, String genre, String publisher, int yearOfPublication){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Book book = (Book) o;

        if (yearOfPublication != book.yearOfPublication) {
            return false;
        }
        if (!Objects.equals(title, book.title)) {
            return false;
        }
        if (!Objects.equals(author, book.author)) {
            return false;
        }
        if (!Objects.equals(genre, book.genre)) {
            return false;
        }
        return Objects.equals(publisher, book.publisher);
    }

    @Override
    public int hashCode(){
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + yearOfPublication;
        return result;
    }

    @Override
    public String toString(){
        return "TITLE=" + title +
                ", AUTHOR=" + author +
                ", GENRE=" + genre +
                ", PUBLISHER=" + publisher +
                ", YEAROFPUBLICATION=" + yearOfPublication;
    }

    @Override
    public int compareTo(Book o){
        return Comparators.TITLE.compare(this, o);
    }


    public static class Comparators {

        public static Comparator<Book> TITLE = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2){
                return o1.title.compareTo(o2.title);
            }
        };

        public static Comparator<Book> AUTHOR = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2){
                return o1.author.compareTo(o2.author);
            }
        };


        public static Comparator<Book> GENRE = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2){
                return o1.genre.compareTo(o2.genre);
            }
        };

        public static Comparator<Book> PUBLISHER = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2){
                return o1.publisher.compareTo(o2.publisher);
            }
        };

        public static Comparator<Book> YEAROFPUBLICATION = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2){
                return o1.yearOfPublication-o2.yearOfPublication;
            }
        };
    }
}
