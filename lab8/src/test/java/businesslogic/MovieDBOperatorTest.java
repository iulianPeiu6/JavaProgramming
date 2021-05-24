package businesslogic;

import models.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class MovieDBOperatorTest {

    private MovieDBOperator movieDBOperator;

    @BeforeEach
    void setUp() throws SQLException {
        movieDBOperator = new MovieDBOperator();
    }

    @Test
    @Order(1)
    void getAllMovies() throws SQLException {
        var allMovies = movieDBOperator.getAllMovies();
        System.out.println(allMovies);
    }

    @Test
    @Order(2)
    void getMovieById() throws SQLException {
        var movie = movieDBOperator.getMovieById(2);
        System.out.println(movie);
    }

    @Test
    @Order(3)
    void deleteMovieFromId() throws SQLException {
        movieDBOperator.deleteMovieFromId(1);
        getAllMovies();
    }

    @Test
    @Order(4)
    void createMovie() throws SQLException {
        var movie = new Movie("Deadpool", "2016-02-12", "02:10:46", 89);
        movieDBOperator.createMovie(movie);
        getAllMovies();
    }
}