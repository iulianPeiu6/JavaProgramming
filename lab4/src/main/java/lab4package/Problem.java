package lab4package;

import java.util.List;

public class Problem {
    private List<School> schools;

    private List<Student> students;

    public Problem(List<School> schools, List<Student> students) {
        this.schools = schools;
        this.students = students;
    }

    public List<School> getSchools() {
        return schools;
    }

    public List<Student> getStudents() {
        return students;
    }
}
