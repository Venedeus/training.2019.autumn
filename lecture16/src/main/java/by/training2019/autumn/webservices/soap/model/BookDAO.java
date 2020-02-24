package by.training2019.autumn.webservices.soap.model;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();

        books.add(new Book("1", "Book #1", 10));
        books.add(new Book("2", "Book #2", 10));
        books.add(new Book("3", "Book #3", 10));
        books.add(new Book("4", "Book #4", 10));

        return books;
    }
}
