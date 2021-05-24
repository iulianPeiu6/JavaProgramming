package lab3package;

import interfaces.Payable;
import interfaces.Visitable;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class City {
    private String name;

    private List<Location> nodes;

    public City(String name) {
        nodes = new ArrayList<>();
        this.name = name;
    }

    public void addLocation(Location node) {
        nodes.add(node);
    }

    public List<Location> getNodes() {
        return nodes;
    }

    public void printSortedLocation(){

        sort(nodes);

        for (Location node : nodes){
            if (node instanceof Visitable && !(node instanceof Payable)){
                System.out.print("\n"+node);
            }
        }
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", nodes=" + nodes +
                '}';
    }
}
