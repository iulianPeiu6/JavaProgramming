package lab2package;

public interface IProblem {

    void addSource(Source source, int index);

    void addDestination(Destination destination, int index);

    void printDetails();

    String toString();

    void solveV1();

    void solveV2();

    void printSolution();

}
