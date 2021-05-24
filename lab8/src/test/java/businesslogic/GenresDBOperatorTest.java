package businesslogic;

import models.Genre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class GenresDBOperatorTest {

    private GenresDBOperator genresDBOperator;

    @BeforeEach
    void setUp() throws SQLException {
        genresDBOperator = new GenresDBOperator();
    }

    @Test
    @Order(1)
    void getAllGenresTest() throws SQLException {
        var allGenres = genresDBOperator.getAllGenres();
        System.out.println("[ALL GENRES TEST]\t " + allGenres);
    }

    @Test
    @Order(2)
    void getGenreByIdTest() throws SQLException {
        var genre = genresDBOperator.getGenreById(2);
        System.out.println("[GENRES FROM ID=2 TEST]\t " + genre);
    }

    @Test
    @Order(3)
    void getGenreByNameTest() throws SQLException {
        var genre = genresDBOperator.getGenreByName("Drama");
        System.out.println("[GENRES FROM Name=\"Drama\" TEST]\t " + genre);
    }

    @Test
    @Order(4)
    void createGenreTest() throws SQLException {
        var genre = new Genre("Romance");
        genresDBOperator.createGenre(genre);
        getAllGenresTest();
    }

    @Test
    @Order(5)
    void deleteGenreTest() throws SQLException {
        genresDBOperator.deleteGenreFromId(10);
        getAllGenresTest();
    }

}