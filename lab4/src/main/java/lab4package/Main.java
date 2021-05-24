package lab4package;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

public class Main {

    public static void runMapsTest(LinkedList<Student> students, TreeSet schools) {

        Map<Student, List<School>> studentsPreferences = new HashMap<>();

        IntStream.rangeClosed(0, 2)
                .forEach(i -> studentsPreferences.put(students.get(i),
                        Arrays.asList(new School("H1"), new School("H2"), new School("H3"))));

        studentsPreferences.forEach((key, value) -> System.out.print("(" + key + "," + value + ")\n"));

        Map<School, List<Student>> schoolsPreferences = new TreeMap<>();

        schools.forEach(school -> schoolsPreferences.put((School) school,
                Arrays.asList(new Student("S1"), new Student("S2"), new Student("S3"))));

        schoolsPreferences.forEach((key, value) -> System.out.print("(" + key + "," + value + ")\n"));

    }

    public static void runCompulsory() {

        var schools = stream(IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School("H" + i))
                .toArray(School[]::new));
        var students = stream(IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new));

        LinkedList<Student> studentList = new LinkedList<>(students.collect(Collectors.toList()));

        studentList.sort(Comparator.comparing(Student::getName));


        TreeSet<School> schoolSet = new TreeSet<School>(schools.collect(Collectors.toList()));

        schoolSet.stream().forEach(student -> System.out.print(student + "\n"));

        runMapsTest(studentList, schoolSet);


    }

    public static void runOptional() {

        Faker faker = new Faker();

        List<Student> students = Arrays.asList(new Student(faker.name().fullName(), 80),
                new Student(faker.name().fullName(), 100),
                new Student(faker.name().fullName(), 60),
                new Student(faker.name().fullName(), 90));

        List<School> schools = Arrays.asList(new School(faker.university().name(), 2, 60),
                new School(faker.university().name(), 2, 80),
                new School(faker.university().name(), 1, 100));

        students.forEach(student -> schools.forEach(school ->
        {
            if (student.getScore() >= school.getMinimumAcceptanceScore())
                System.out.print(student + " CAN GO TO " + school + "\n");
        }));

        Solution solution = new Solution(new Problem(schools, students));

        solution.solveV1();

        solution.printSolution();

    }

    public static void runBonus() {
        //not tested
    }

    public static void main(String[] args) {

        runCompulsory();

        runOptional();

        runBonus();

    }
}
