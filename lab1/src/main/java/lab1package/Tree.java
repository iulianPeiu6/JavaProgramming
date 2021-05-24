/***
 * @author Peiu Iulian-Cosmin
 * references: https://en.wikipedia.org/wiki/Pr%C3%BCfer_sequence
 */
package lab1package;

import java.util.Vector;

public class Tree implements ITree {
    private static final int MAX_NODES = 25;
    private int n;
    private Vector<Vector<Integer>> edges;

    public Tree() {
        this.n = 0;
    }

    private void addEdge(int s, int t) {
        edges.get(s).add(t);
    }

    private Vector<Integer> generatePuferSeq(int size) {
        Vector<Integer> pruferSeq = new Vector<Integer>(size);

        for (int i = 0; i < n - 2; i++)
            pruferSeq.add((int) (Math.random() * (n - 1)));

        return pruferSeq;
    }

    private void createEmptyTree() {
        this.n = (int) (Math.random() * (MAX_NODES)) + 2;
        edges = new Vector<Vector<Integer>>(n);
        for (int i = 0; i < n; i++) {
            Vector<Integer> node = new Vector<Integer>();
            edges.add(node);
        }
    }

    private Vector<Integer> getDegrees(Vector<Integer> pruferSeq) {
        Vector<Integer> degree = new Vector<Integer>(n);
        for (int i = 0; i < n; i++)
            degree.add(1);

        for (int i = 0; i < n - 2; i++)
            degree.set(pruferSeq.get(i), degree.get(pruferSeq.get(i)) + 1);

        return degree;

    }

    private void updateTree(Vector<Integer> pruferSeq, Vector<Integer> degree) {
        for (int i = 0; i < n - 2; i++)
            for (int j = 0; j < n; j++)
                if (degree.get(j) == 1) {
                    addEdge(pruferSeq.get(i), j);
                    degree.set(pruferSeq.get(i), degree.get(pruferSeq.get(i)) - 1);
                    degree.set(j, degree.get(j) - 1);
                    break;
                }

        int u = 0, v = 0;
        for (int i = 0; i < n; i++)
            if (degree.get(i) == 1) {
                if (u == 0)
                    u = i;
                else {
                    v = i;
                    break;
                }
            }
        addEdge(u, v);
    }

    public void generateRandTree() {

        createEmptyTree();

        Vector<Integer> pruferSeq = generatePuferSeq(n - 2);

        Vector<Integer> degree = getDegrees(pruferSeq);

        updateTree(pruferSeq, degree);

    }


    public void printAdjList() {
        for (int i = 0; i < n; i++) {
            System.out.print(Integer.toString(i) + "->");
            for (int j = 0; j < edges.get(i).size(); j++) {
                System.out.print(Integer.toString(edges.get(i).get(j)) + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    private boolean isLeaf(int node) {
        if (edges.get(node).isEmpty())
            return true;
        return false;
    }

    private void printNode(int node, int depth) {
        for (int i = 0; i < depth; i++)
            System.out.print("\t");

        if (isLeaf(node))
            System.out.print("-");
        else
            System.out.print("+");

        System.out.print("node" + Integer.toString(node) + "\n");
    }

    private void printTree(int currentNode, int depth) {

        printNode(currentNode, depth);

        for (int i = 0; i < edges.get(currentNode).size(); i++)
            printTree(edges.get(currentNode).get(i), depth + 1);
    }

    private boolean isRoot(int node) {

        for (int i = 0; i < n; i++)
            for (int j = 0; j < edges.get(i).size(); j++)
                if (edges.get(i).get(j) == node)
                    return false;

        return true;
    }

    private int getRoot() {

        for (int node = 0; node < n; node++)
            if (isRoot(node))
                return node;

        return 0;
    }

    public void visualiseTree() {

        int root = getRoot();

        printTree(root, 0);
    }

}
