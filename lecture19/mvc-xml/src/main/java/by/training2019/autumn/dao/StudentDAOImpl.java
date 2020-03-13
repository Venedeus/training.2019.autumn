package by.training2019.autumn.dao;

import by.training2019.autumn.model.Faculty;
import by.training2019.autumn.model.Student;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements DAO {
    private List<Student> students;

    public StudentDAOImpl(DAO dao) {
        students = new ArrayList<>();

        List<Faculty> faculties = dao.getAll();

        students.add(new Student("Adam", "Smith", faculties.get(new SecureRandom().nextInt(faculties.size()))));
        students.add(new Student("Evgeniy", "Gershin", faculties.get(new SecureRandom().nextInt(faculties.size()))));
        students.add(new Student("Sergey", "Ovseev", faculties.get(new SecureRandom().nextInt(faculties.size()))));
        students.add(new Student("Tildo", "Keshin", faculties.get(new SecureRandom().nextInt(faculties.size()))));
    }

    @Override
    public List<Student> getAll() {
        return students;
    }
}
