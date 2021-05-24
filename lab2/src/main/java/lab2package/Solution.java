/**
 * @author Peiu Iulian-Cosmin
 */
package lab2package;

import java.util.Vector;

public class Solution {
    private int numOfSolPairs;
    private Vector<Pair> solPairs;

    public Solution(int numOfSolPairs, Vector<Pair> solPairs) {
        this.numOfSolPairs = numOfSolPairs;
        this.solPairs = solPairs;
    }

    public int getNumOfSolPairs() {
        return numOfSolPairs;
    }

    public void setNumOfSolPairs(int numOfSolPairs) {
        this.numOfSolPairs = numOfSolPairs;
    }

    public Vector<Pair> getSolPairs() {
        return solPairs;
    }

    public void setSolPairs(Vector<Pair> solPairs) {
        this.solPairs = solPairs;
    }
}
