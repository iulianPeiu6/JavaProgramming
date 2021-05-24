package bonus;

import mediaset.AbstractMediaUnit;
import multimediamanagement.Catalog;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {

    private Catalog catalog;
    private List<AbstractMediaUnit> vertexList;
    private Map<Integer,Integer> adjMap;

    public Graph(Catalog catalog) {
        vertexList = catalog.getContent();

        adjMap = new HashMap<>();

        initAdjMatrix();
    }

    private void initAdjMatrix(){
        for (int i=0;i<vertexList.size();i++)
            for (int j=0;j<vertexList.size();j++){
                if (i==j)
                    continue;
                else if (commonInterests(i,j))
                    adjMap.put(i,j);
            }
    }

    private boolean commonInterests(int from, int to){
        if (!vertexList.get(from).getClass().equals(vertexList.get(to).getClass()))
            return false;

        if (vertexList.get(from).getName().equals(vertexList.get(to).getName()))
            return true;

        return false;
    }

    public void colorGraph(){

        Map<AbstractMediaUnit, Boolean> availableVertex = new HashMap<>();
        Map<AbstractMediaUnit, Integer> colorRelation = new HashMap<>();

        for (var vertex : vertexList) {
            colorRelation.put(vertex, -1);
            availableVertex.put(vertex,false);
        }

        for (var vertex : vertexList){

            ///for (var vertexIndex : adjMap.get(vertexList.indexOf(vertex)))
        }


    }

}
