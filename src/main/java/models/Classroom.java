package models;

import java.util.ArrayList;
import java.util.List;

public class Classroom {

    private String name;
    private List<Lecture> lectures;

    public Classroom(){

    }
    public Classroom(String name) {
        this.name = name;
        this.lectures = new ArrayList<>();
    }
    public Classroom(String name, List<Lecture> lectures) {
        this.name = name;
        this.lectures = lectures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public void addLectures(Lecture lecture) {
        this.lectures.add(lecture);
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "name='" + name + '\'' + lectures.toString() +
            '}';
    }
}
