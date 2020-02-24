package by.training2019.autumn.controllers;

import by.training2019.autumn.model.BookDAO;

public class AbstractController {
    private static BookDAO dao = new BookDAO();

    public BookDAO getDao() {
        return dao;
    }
}
