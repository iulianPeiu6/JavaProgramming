/**
 * @author Peiu Iulian-Cosmin
 */
package lab2package;

public class Main {

    public static void compulsoryTest() {
        System.out.print("Compulsory Test:\n");
        Source[] sources = new Source[3];
        Destination[] destinations = new Destination[3];
        int[][] matrixCost = {{2, 3, 1}, {5, 4, 8}, {5, 6, 8}};

        sources[0] = new Source("S1", 10);
        sources[1] = new Source("S2", 35);
        sources[2] = new Source("S3", 25);

        destinations[0] = new Destination("D1", 20);
        destinations[1] = new Destination("D2", 25);
        destinations[2] = new Destination("D3", 25);

        Problem problem = new Problem(3, 3, sources, destinations, matrixCost);

        problem.printDetails();
    }

    public static void optionalTest() {
        System.out.print("\n\nOptional Test:\n");
        Source[] sources = new Source[3];
        Destination[] destinations = new Destination[3];
        int[][] matrixCost = {{2, 3, 1}, {5, 4, 8}, {5, 6, 8}};

        sources[0] = new Source("S1", 10);
        sources[1] = new Source("S2", 35);
        sources[2] = new Source("S3", 25);

        destinations[0] = new Destination("D1", 20);
        destinations[1] = new Destination("D2", 25);
        destinations[2] = new Destination("D3", 25);

        Problem problem = new Problem(3, 3, sources, destinations, matrixCost);

        problem.printDetails();
        problem.solveV1();
        problem.printSolution();
    }

    public static void bonusTest() {
        System.out.print("\n\nBonus Test:\n");
        Source[] sources = new Source[3];
        Destination[] destinations = new Destination[3];
        int[][] matrixCost = {{2, 3, 1}, {5, 4, 8}, {5, 6, 8}};

        sources[0] = new Source("S1", 10);
        sources[1] = new Source("S2", 35);
        sources[2] = new Source("S3", 25);

        destinations[0] = new Destination("D1", 20);
        destinations[1] = new Destination("D2", 25);
        destinations[2] = new Destination("D3", 25);


        Problem problem = new Problem(3, 3, sources, destinations, matrixCost);

        problem.printDetails();
        problem.solveV2();
        problem.printSolution();

    }

    public static void main(String[] args) {

        compulsoryTest();

        optionalTest();

        bonusTest();


    }
}
