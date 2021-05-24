package entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "Movies")
public class Movie implements Comparable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String releaseDate;

    private String duration;

    private int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(score, ((Movie) o).getScore());
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", duration='" + duration + '\'' +
                ", score=" + score +
                '}';
    }
}
