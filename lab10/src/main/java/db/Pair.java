package db;

public class Pair {
    public String from, to;

    public Pair(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return from + ':';
    }
}
