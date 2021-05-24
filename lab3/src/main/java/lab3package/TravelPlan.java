package lab3package;

import java.util.*;

public class TravelPlan {
    private City city;

    private Set<Location> unsettledNodes;

    private Map<Location,Location> previousLocation;

    private Map<Location,Integer> costToDestination;

    public TravelPlan(City city) {
        this.city = city;
        this.unsettledNodes = new HashSet<Location>(city.getNodes().size());
        this.previousLocation = new HashMap<Location,Location>();
        this.costToDestination = new HashMap<>();

        for (Location node : city.getNodes()){
            costToDestination.put(node, Integer.MAX_VALUE);
            unsettledNodes.add(node);

        }

    }

    private Location getNextNode(){

        Location nextNode=null;

        for (Location node : unsettledNodes){
            if (nextNode==null)
                nextNode=node;
            else
                if (costToDestination.get(node)<costToDestination.get(nextNode))
                    nextNode=node;
        }

        return nextNode;

    }

    public int getShortestPathBetween(Location start, Location finish){

        costToDestination.put(start,0);

        while (!unsettledNodes.isEmpty()){

            Location currentNode = getNextNode();

            unsettledNodes.remove(currentNode);

            processNeighbors(currentNode);
        }

        return costToDestination.get(finish);

    }

    public void processNeighbors(Location currentNode){

        Iterator<Map.Entry<Location, Integer>> neighborsIterator = currentNode.getCost().entrySet().iterator();

        while(neighborsIterator.hasNext()){

            var currentNeighbor = neighborsIterator.next();

            if (unsettledNodes.contains(currentNeighbor.getKey())){
                int newDistance= costToDestination.get(currentNode) + currentNeighbor.getValue();

                if (costToDestination.get(currentNeighbor.getKey()) > newDistance){
                    costToDestination.put(currentNeighbor.getKey(),newDistance);
                    previousLocation.put(currentNeighbor.getKey(),currentNode);
                }
            }
        }

    }

    private int pathLength;
    private List<List<Location>> paths;

    public List<Location> createPlan(Location start){

        List<Location> bestPath = null;
        for (pathLength=city.getNodes().size(); pathLength>0;pathLength++){

            paths.clear();
            generateHamiltonianCycle(0,new ArrayList<>(),new ArrayList<>(city.getNodes()));
            for (List<Location> path : paths)
                if (path.contains(start))
                    bestPath=path;
        }

        return bestPath;
    }


    private void generateHamiltonianCycle(int currentIndex, List<Location> currentPath, List<Location> unvisitedLocations){

        while(true){

            setNextLocation(currentIndex, currentPath, unvisitedLocations);

            if (currentPath.get(currentIndex)==null)
                return ;

            if (currentIndex == pathLength)
                paths.add(currentPath);
            else
                generateHamiltonianCycle(currentIndex+1, currentPath, unvisitedLocations);

        }

    }

    private boolean edgeBetween(Location first, Location second){

        if (city.getNodes().contains(first))
            if (first.getCost().containsKey(second))
                return true;

        return false;
    }

    private void setNextLocation(int currentIndex,List<Location> currentPath, List<Location> unvisitedLocations){

        while (true){
            currentPath.set(currentIndex, unvisitedLocations.get((currentIndex+1)%pathLength));

            if (currentPath.get(currentIndex)==null)
                return ;

            int index=0;

            if (edgeBetween(currentPath.get(currentIndex),currentPath.get(currentIndex-1)))
                    for (index=0;index<pathLength;index++)
                        if (currentPath.get(index)==currentPath.get(currentIndex))
                            break;
            if (index==currentIndex)
                if (currentIndex<pathLength ||
                        currentIndex==pathLength &&
                                edgeBetween(currentPath.get(currentIndex),currentPath.get(0)))

                    return ;

        }

    }


}
