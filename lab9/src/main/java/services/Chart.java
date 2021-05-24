package services;

import entities.Movie;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Chart {

    private final String name;

    private final Date creationDate;

    private final List<Movie> movies;

    public Chart(String name) {
        this.name = name;
        this.creationDate = new Date(System.currentTimeMillis());
        movies = getTopMovies(10);
    }

    public Chart(String name, List<Movie> movies) {
        this.name = name;
        this.creationDate = new Date(System.currentTimeMillis());
        this.movies = movies;
    }

    public List<Movie> getTopMovies(int size) {
        IRepository<Movie> movieIRepository = new Repository<>(Movie.class);
        List<Movie> top10 = movieIRepository.getAll();

        Collections.sort(top10);

        return top10.subList(0,size);
    }
}
