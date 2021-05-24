package algorithms;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    private int dimension;

    private int[][] adjMatrix;

    public Graph(int dimension) {
        this.dimension = dimension;
        initAdjMatrix();
    }

    private void initAdjMatrix() {
        adjMatrix = new int[dimension][dimension];

        for (int i=0; i<dimension ;i++)
            for (int j=0; j<dimension; j++)
                adjMatrix[i][j] = 0;
    }

    public void addEdge(int from, int to){
        adjMatrix[from][to] = adjMatrix[to][from] = 1;
    }

    Map<Integer,Integer> matching;

    public Map<Integer, Integer> getMatching() {
        return matching;
    }

    public void createMaximalCustomMatching(){
        matching = new HashMap<>();

        //TODO
    }
}
