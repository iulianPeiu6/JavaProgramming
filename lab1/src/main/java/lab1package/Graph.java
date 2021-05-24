/***
 * @author Peiu Iulian-Cosmin
 */
package lab1package;

public class Graph {
    private int n;
    private int[] connComps;
    private int[][] adjGraphMatrix;
    private int[][] adjPartialTreeMatrix;
    private boolean[] visited;
    private int numOfConnComps;

    public Graph(int n) {
        this.n = n;
        this.connComps = new int[n];
        this.adjGraphMatrix = new int[n][n];
        this.adjPartialTreeMatrix = new int[n][n];
        this.visited = new boolean[n];
    }

    public void generateRandomGraph() {
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                adjGraphMatrix[i][j] = adjGraphMatrix[j][i] = (int) (Math.random() * 2);

        this.numOfConnComps = 0;
    }

    public void printAdjGraphMatrix() {
        System.out.print("Graph adjacency matrix: \n");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(Integer.toString(adjGraphMatrix[i][j]) + " ");
            System.out.print("\n");
        }
    }

    private void addTreeEdge(int s, int t) {
        adjPartialTreeMatrix[s][t] = adjPartialTreeMatrix[t][s] = 1;
    }

    private void computeDfs(int s) {
        visited[s] = true;
        connComps[s] = numOfConnComps;

        for (int i = 0; i < n; i++) {
            if (adjGraphMatrix[s][i] == 1 && (!visited[i])) {
                addTreeEdge(s, i);
                connComps[i] = numOfConnComps;
                computeDfs(i);
            }
        }
    }

    public boolean isConnected() {
        numOfConnComps = 0;

        for (int i = 0; i < n; i++) {
            visited[i] = false;
            connComps[i] = -1;
        }

        for (int i = 0; i < n; i++)
            if (!visited[i]) {
                computeDfs(i);
                numOfConnComps++;
            }

        return (numOfConnComps == 1);
    }

    public void printConnComps() {
        System.out.print("Connected components: \n");
        for (int i = 0; i < n; i++)
            System.out.print(Integer.toString(connComps[i]) + " ");
        System.out.print("\n");
    }

    public void printAdjPartialTree() {
        System.out.print("Partial tree adjacency matrix: \n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(Integer.toString(adjPartialTreeMatrix[i][j]) + " ");
            System.out.print("\n");
        }
    }
}
