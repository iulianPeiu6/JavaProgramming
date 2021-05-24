package entities;

import javax.persistence.*;

@Entity
@Table(name = "Directors")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int movieId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", movieId=" + movieId +
                '}';
    }
}
