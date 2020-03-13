package by.training2019.autumn.dao;

import by.training2019.autumn.model.Faculty;

import java.util.ArrayList;
import java.util.List;

public class FacultyDAOImpl implements DAO {
    private List<Faculty> faculties;

    public FacultyDAOImpl() {
        faculties = new ArrayList<>();

        faculties.add(new Faculty("Electric"));
        faculties.add(new Faculty("Transport"));
        faculties.add(new Faculty("Military"));
        faculties.add(new Faculty("Economy"));
    }

    @Override
    public List<Faculty> getAll() {
        return faculties;
    }
}
