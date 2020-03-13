package by.training2019.autumn.model;

public class Faculty {
    private static int ids = 0;
    private int id;
    private String title;

    public Faculty(String title) {
        this.id = ids;
        this.title = title;
        ids++;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
