package models;

public class Actor {
    private int id;

    private String name;

    private int fromMovie;

    public Actor(int id, String name, int fromMovie) {
        this.id = id;
        this.name = name;
        this.fromMovie = fromMovie;
    }

    public Actor(String name, int fromMovie) {
        this.name = name;
        this.fromMovie = fromMovie;
    }

    public String getName() {
        return name;
    }

    public int getFromMovie() {
        return fromMovie;
    }
}
