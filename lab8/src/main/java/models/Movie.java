package models;

public class Movie {
    private int id;

    private String title;

    private String releaseDate;

    private String duration;

    private int score;

    public Movie(int id, String title, String releaseDate, String duration, int score) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.score = score;
    }

    public Movie(String title, String releaseDate, String duration, int score) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getDuration() {
        return duration;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", score=" + score +
                '}';
    }
}
