/**
 * @author Peiu Iulian-Cosmin
 */
package lab2package;

import java.util.Arrays;
import java.util.Vector;

public class Problem implements IProblem{

    private int numOfSources;
    private int numOfDestinations;
    private Source[] sources;
    private Destination[] destinations;
    private final int[][] matrixCost;
    private Solution solution;

    public Problem(int numOfSources, int numOfDestinations, Source[] sources, Destination[] destinations, int[][] matrixCost) {

        this.numOfSources = numOfSources;
        this.numOfDestinations = numOfDestinations;
        this.sources = new Source[numOfSources];
        this.destinations = new Destination[numOfDestinations];

        for (int i = 0, n = numOfSources; i < n; i++)
            addSource(sources[i], i);

        for (int i = 0, n = numOfDestinations; i < n; i++)
            addDestination(destinations[i], i);

        this.matrixCost = matrixCost;
    }

    private boolean sourceExists(Source source) {

        for (int i = 0; i < numOfSources; i++) {
            if (sources[i] == null)
                break;
            if (source.equals(sources[i]))
                return true;
        }

        return false;
    }

    private boolean destinationExists(Destination destination) {

        for (int i = 0; i < numOfDestinations; i++) {
            if (destinations[i] == null)
                break;
            if (destination.equals(destinations[i]))
                return true;
        }

        return false;
    }

    public void addSource(Source source, int index) {
        if (sourceExists(source)) {
            numOfSources--;
            sources = Arrays.copyOf(sources, sources.length - 1);
        } else
            sources[index] = source;
    }

    public void addDestination(Destination destination, int index) {
        if (destinationExists(destination)) {
            numOfDestinations--;
            destinations = Arrays.copyOf(destinations, destinations.length - 1);
        } else
            destinations[index] = destination;
    }

    public void printDetails() {
        System.out.print("\t\t");

        for (Destination value : destinations) System.out.print(value.getName() + "\t");

        System.out.print("Supply\n");

        for (int i = 0; i < sources.length; i++) {
            System.out.print(sources[i].getName() + "\t\t");
            for (int j = 0; j < destinations.length; j++)
                System.out.print(matrixCost[i][j] + "\t");
            System.out.print(sources[i].getSupply() + "\n");
        }

        System.out.print("Demands\t");

        for (Destination destination : destinations) System.out.print(destination.getDemand() + "\t");

    }

    @Override
    public String toString() {
        return "Problem{" +
                "numOfSources=" + numOfSources +
                ", numOfDestinations=" + numOfDestinations +
                ", sources=" + Arrays.toString(sources) +
                ", destinations=" + Arrays.toString(destinations) +
                ", matrixCost=" + Arrays.toString(matrixCost) +
                '}';
    }

    private final int MAX_SOL_PAIRS = 100;

    private int[] getSupplies() {
        int[] tempSupplies;
        tempSupplies = new int[numOfSources];

        for (int i = 0; i < numOfSources; i++)
            tempSupplies[i] = sources[i].getSupply();

        return tempSupplies;
    }

    private int[] getDemands() {
        int[] tempDemands;
        tempDemands = new int[numOfDestinations];

        for (int i = 0; i < numOfDestinations; i++)
            tempDemands[i] = destinations[i].getDemand();

        return tempDemands;
    }

    public void solveV1() {
        int[] supplies, demands;
        supplies = getDemands();
        demands = getSupplies();

        int numOfPairs = 0, s = 0, t = 0;
        Pair[] pairs = new Pair[MAX_SOL_PAIRS];
        while (s != numOfSources && t != numOfDestinations) {
            pairs[numOfPairs++] = new Pair(s, t);

            if (supplies[s] < demands[t]) {
                demands[t] = demands[t] - supplies[s];
                supplies[s] = 0;
                s++;
            } else if (supplies[s] == demands[t]) {
                demands[t] = 0;
                supplies[s] = 0;
                s++;
                t++;
            } else {
                supplies[s] = supplies[s] - demands[t];
                t++;
            }
        }
        solution = new Solution(numOfPairs, new Vector<>(Arrays.asList(pairs)));

    }


    private int getTwoLeastAbsDiff(int[] elements) {
        int firstMin, secondMin;
        firstMin = Integer.MAX_VALUE;
        secondMin = Integer.MAX_VALUE;

        for (int element : elements) {
            if (element != -1)
                if (element < secondMin) {
                    secondMin = element;
                    if (secondMin < firstMin) {
                        int temp = secondMin;
                        secondMin = firstMin;
                        firstMin = temp;
                    }
                }
        }

        if (firstMin == Integer.MAX_VALUE)
            return -1;
        if (secondMin == Integer.MAX_VALUE)
            return firstMin;
        return Math.abs(firstMin - secondMin);
    }

    private int[] getSourcesPenalties(int[][] tempMatrixCost, int[] tempSupply) {
        int[] penalties = new int[numOfSources];
        for (int i = 0; i < numOfSources; i++) {
            if (tempSupply[i] != -1) {
                int[] elements = new int[numOfDestinations];
                if (numOfDestinations >= 0) System.arraycopy(tempMatrixCost[i], 0, elements, 0, numOfDestinations);
                penalties[i] = getTwoLeastAbsDiff(elements);
            }

        }

        return penalties;
    }

    private int[] getDestinationsPenalties(int[][] tempMatrixCost, int[] tempDemands) {
        int[] penalties = new int[numOfSources];
        for (int i = 0; i < numOfDestinations; i++) {
            if (tempDemands[i] != -1) {
                int[] elements = new int[numOfSources];
                for (int j = 0; j < numOfSources; j++)
                    elements[j] = tempMatrixCost[j][i];
                penalties[i] = getTwoLeastAbsDiff(elements);
            }

        }

        return penalties;
    }

    private int max(int[] elements) {
        int index = -1;

        for (int i = 0; i < elements.length; i++) {

            if (elements[i] != -1) {
                if (index == -1)
                    index = i;
                else if (elements[index] < elements[i])
                    index = i;

            }
        }

        return index;
    }

    private int minOnRow(int[][] tempMatrixCost, int row) {
        int indexMin = -1;
        for (int i = 0; i < numOfDestinations; i++) {
            if (tempMatrixCost[row][i] != -1) {
                if (indexMin == -1)
                    indexMin = i;
                else if (tempMatrixCost[row][i] < tempMatrixCost[row][indexMin])
                    indexMin = i;
            }
        }

        return indexMin;
    }

    private int minOnColumn(int[][] tempMatrixCost, int column) {
        int indexMin = -1;
        for (int i = 0; i < numOfSources; i++) {
            if (tempMatrixCost[i][column] != -1) {
                if (indexMin == -1)
                    indexMin = i;
                else if (tempMatrixCost[i][column] < tempMatrixCost[indexMin][column])
                    indexMin = i;
            }
        }

        return indexMin;
    }

    private int[] partialSupplies, partialDemands;


    private void updateTempCostMatrix(int[][] tempMatrixCost, int rowUpdate, int columnUpdate) {
        if (partialSupplies[rowUpdate] == -1)
            for (int i = 0; i < numOfDestinations; i++)
                tempMatrixCost[rowUpdate][i] = -1;

        if (partialDemands[columnUpdate] == -1)
            for (int i = 0; i < numOfSources; i++)
                tempMatrixCost[i][columnUpdate] = -1;

    }

    private boolean problemSolved() {
        for (int i = 0; i < numOfSources; i++)
            if (partialSupplies[i] != -1)
                return false;

        for (int i = 0; i < numOfDestinations; i++)
            if (partialDemands[i] != -1)
                return false;

        return true;
    }

    private void updatePartialSuppliesDemands(int value, int fromSource, int toDestination) {
        partialSupplies[fromSource] -= value;
        partialDemands[toDestination] -= value;
        if (partialSupplies[fromSource] == 0)
            partialSupplies[fromSource] = -1;
        if (partialDemands[toDestination] == 0)
            partialDemands[toDestination] = -1;
    }

    public void solveV2() {
        int[] sourcesPenalties, destinationsPenalties;
        int[][] tempMatrixCost = matrixCost;
        partialSupplies = getSupplies();
        partialDemands = getDemands();

        int numOfPairs = 0;
        Pair[] pairs = new Pair[MAX_SOL_PAIRS];
        while (true) {

            sourcesPenalties = getSourcesPenalties(tempMatrixCost, partialSupplies);
            destinationsPenalties = getDestinationsPenalties(tempMatrixCost, partialDemands);

            if (problemSolved())
                break;

            int fromSource = max(sourcesPenalties);
            int toDestination = max(destinationsPenalties);

            if (sourcesPenalties[fromSource] < destinationsPenalties[toDestination])
                fromSource = minOnColumn(tempMatrixCost, toDestination);
            else
                toDestination = minOnRow(tempMatrixCost, fromSource);

            pairs[numOfPairs++] = new Pair(fromSource, toDestination);

            updatePartialSuppliesDemands(Math.min(partialSupplies[fromSource], partialDemands[toDestination]),
                    fromSource,
                    toDestination);

            updateTempCostMatrix(tempMatrixCost, fromSource, toDestination);
        }
        solution = new Solution(numOfPairs, new Vector<>(Arrays.asList(pairs)));
    }

    public void printSolution() {
        System.out.print("\n\nSolution:\n");
        for (int i = 0; i < solution.getNumOfSolPairs(); i++)
            System.out.print(sources[solution.getSolPairs().get(i).getFirst()].getName()
                    + "->"
                    + destinations[solution.getSolPairs().get(i).getSecond()].getName()
                    + "\n");
    }
}
