package lab4package;

import java.util.ArrayList;
import java.util.List;

public class School implements Comparable<School> {

    private String name;

    private int capacity;

    private int minimumAcceptanceScore;

    public int getMinimumAcceptanceScore() {
        return minimumAcceptanceScore;
    }

    public School(String name, int capacity, int minimumAcceptanceScore) {
        this.name = name;
        this.capacity = capacity;
        this.minimumAcceptanceScore = minimumAcceptanceScore;
    }

    private List<Student> preferences;

    public School(String name, int capacity, List<Student> preferences) {
        this.name = name;
        this.capacity = capacity;
        this.preferences = preferences;
    }

    public School(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.preferences = new ArrayList<>();
    }

    public School(String name) {
        this.name = name;
        this.capacity = 0;
        this.preferences = new ArrayList<>();
    }

    public void addPreference(Student student) {

        preferences.add(student);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", minimumAcceptanceScore=" + minimumAcceptanceScore +
                ", preferences=" + preferences +
                '}';
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(School school) {

        return school.getName().compareTo(name);

    }
}
