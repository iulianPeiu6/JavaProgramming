package models;

public class Director {
    private int id;

    private String name;

    private int ofMovie;

    public Director(int id, String name, int fromMovie) {
        this.id = id;
        this.name = name;
        this.ofMovie = fromMovie;
    }

    public Director(String name, int fromMovie) {
        this.name = name;
        this.ofMovie = fromMovie;
    }

    public String getName() {
        return name;
    }

    public int getOfMovie() {
        return ofMovie;
    }
}
