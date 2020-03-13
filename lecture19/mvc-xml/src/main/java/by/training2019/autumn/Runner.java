package by.training2019.autumn;

import by.training2019.autumn.dao.DAO;
import by.training2019.autumn.dao.FacultyDAOImpl;
import by.training2019.autumn.dao.StudentDAOImpl;

public class Runner {
    public static void main(String[] args) {
        DAO facultyDAO = new FacultyDAOImpl();
        DAO studentDAO = new StudentDAOImpl(facultyDAO);

        facultyDAO.getAll().forEach(System.out::println);
        studentDAO.getAll().forEach(System.out::println);

    }
}
