package lab3package;

import interfaces.Classifiable;
import interfaces.Payable;
import interfaces.Visitable;

public class Restaurant extends Location implements Classifiable {

    private int rank;

    public Restaurant(String name) {
        super(name);
    }

    @Override
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

}
