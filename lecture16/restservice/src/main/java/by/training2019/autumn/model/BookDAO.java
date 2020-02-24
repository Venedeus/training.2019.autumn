package by.training2019.autumn.model;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private static List<Book> books = new ArrayList<>();

    static {
        books.add(new Book(1, "Book #1", 10));
        books.add(new Book(2, "Book #2", 10));
        books.add(new Book(3, "Book #3", 10));
        books.add(new Book(4, "Book #4", 10));
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public int getNextId() {
        return books.size();
    }

    public String getBookById(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst().get().getTitle();
    }

    public void deleteBookById(int id) {
        Book book = books.stream().filter(b -> b.getId() == id).findFirst().get();

        books.remove(book);
    }
}
