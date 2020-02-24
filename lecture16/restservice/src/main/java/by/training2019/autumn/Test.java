package by.training2019.autumn;

import by.training2019.autumn.model.BookDAO;

public class Test {
    public static void main(String[] args) {
        BookDAO dao = new BookDAO();

        System.out.println(dao.getBookById(1));
        System.out.println(dao.getBooks());
        dao.deleteBookById(2);
        System.out.println(dao.getBooks());
    }
}
