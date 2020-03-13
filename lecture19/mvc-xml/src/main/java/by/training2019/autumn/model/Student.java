package by.training2019.autumn.model;

public class Student {
    private static int ids = 0;
    private int id;
    private String firstName;
    private String lastName;
    private Faculty faculty;

    public Student(String firstName, String lastName, Faculty faculty) {
        this.id = ids;
        this.firstName = firstName;
        this.lastName = lastName;
        this.faculty = faculty;
        ids++;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", faculty=" + faculty +
                '}';
    }
}
