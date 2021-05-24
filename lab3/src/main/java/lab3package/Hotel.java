package lab3package;

import interfaces.Classifiable;

public class Hotel extends Location implements Classifiable {

    private int rank;

    public Hotel(String name) {
        super(name);
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public int getRank() {
        return rank;
    }

}
