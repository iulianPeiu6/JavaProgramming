package lab4package;

import java.util.*;

public class Solution {
    private Problem problem;

    private Map<Student, School> matching;

    public Solution(Problem problem) {
        this.problem = problem;
    }

    private List<Student> tempStudentsList;
    private List<School> tempSchoolsList;

    public void solveV1() {
        matching = new HashMap<>();

        tempStudentsList = problem.getStudents();
        tempSchoolsList = problem.getSchools();

        tempStudentsList.sort(Collections.reverseOrder(Comparator.comparing(Student::getScore)));
        tempSchoolsList.sort(Collections.reverseOrder(Comparator.comparing(School::getMinimumAcceptanceScore)));

        for (Student student : tempStudentsList) {
            int schoolIndex = 0;
            while (tempSchoolsList.get(schoolIndex).getCapacity() == 0)
                schoolIndex++;

            tempSchoolsList.get(schoolIndex).setCapacity(tempSchoolsList.get(schoolIndex).getCapacity() - 1);
            matching.put(student, tempSchoolsList.get(schoolIndex));
        }
    }

    public void solveV2() {
        matching = new HashMap<>();

        tempStudentsList = problem.getStudents();
        tempSchoolsList = problem.getSchools();

        boolean assigned = false;
        for (Student student : tempStudentsList) {
            for (School school : student.getPreferences()) {
                if (school.getCapacity() != 0) {
                    matching.put(student, school);
                    school.setCapacity(school.getCapacity() - 1);
                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                System.out.print("no solution");
                return;
            }
        }
    }

    public void printSolution() {

        if (matching == null)
            System.out.print("no solution");
        else
            matching.forEach((key, value) -> System.out.print(key + " GOES TO " + value + "\n"));
    }
}
