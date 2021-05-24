/***
 * @author Peiu Iulian-Cosmin
 */
package lab1package;

import java.util.Scanner;

public class Main {
    public static void compulsoryTest() {
        System.out.print("\nCompulsory Test:\n");
        Language languages = new Language();
        languages.run();
    }

    public static void optionalTest() {
        System.out.print("\nOptional Test:\n");
        System.out.print("n=");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if (n % 2 == 0)
            System.out.print("n needs to be odd\n");
        else {
            Graph graph = new Graph(n);
            graph.generateRandomGraph();

            graph.printAdjGraphMatrix();

            if (!graph.isConnected())
                graph.printConnComps();
            else
                graph.printAdjPartialTree();
        }
    }

    public static void bonusTest() {
        System.out.print("\nBonus Test:\n");
        Tree tree = new Tree();
        tree.generateRandTree();
        tree.printAdjList();
        tree.visualiseTree();
    }

    public static void main(String args[]) {

        compulsoryTest();

        optionalTest();

        bonusTest();

    }
}
