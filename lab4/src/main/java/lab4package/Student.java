package lab4package;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;

    private int score;

    public int getScore() {
        return score;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    private List<School> preferences;

    public Student(String name) {
        this.name = name;
        this.preferences = new ArrayList<School>();
    }

    public Student(String name, List<School> preferences) {
        this.name = name;
        this.preferences = preferences;
    }

    public void addPreference(School school) {

        preferences.add(school);
    }

    public String getName() {
        return name;
    }

    public List<School> getPreferences() {
        return preferences;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", preferences=" + preferences +
                '}';
    }
}
