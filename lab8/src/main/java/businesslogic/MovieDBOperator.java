package businesslogic;

import dbconn.DBConnectionSingleton;
import dbconn.DBConnectionHikari;
import models.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MovieDBOperator {

    private Statement statement;

    public MovieDBOperator() throws SQLException {
        statement = DBConnectionSingleton.getInstance()
                .connection
                .createStatement();
    }

    public MovieDBOperator(String url) throws SQLException {
        statement = (new DBConnectionHikari()).getConnection()
                .createStatement();
    }

    public List<Movie> getAllMovies() throws SQLException {
        List<Movie> allMovies = new ArrayList<>();

        String getAllMoviesSQL = "SELECT * FROM Movies;";
        ResultSet result = statement.executeQuery(getAllMoviesSQL);

        while (result.next()) {
            int id = result.getInt(1);
            String title = result.getString(2);
            String releaseDate = result.getString(3);
            String duration = result.getString(4);
            int score = result.getInt(5);
            Movie currentMovie = new Movie(id, title, releaseDate, duration, score);
            allMovies.add(currentMovie);
        }

        return allMovies;
    }

    public Movie getMovieById(int id) throws SQLException {
        Movie movie = null;

        String getMovieByIdSQL = "SELECT * FROM Movies WHERE Id=" + id + ";";
        ResultSet result = statement.executeQuery(getMovieByIdSQL);

        if (result.next()) {
            String title = result.getString(2);
            String releaseDate = result.getString(3);
            String duration = result.getString(4);
            int score = result.getInt(5);
            movie = new Movie(id, title, releaseDate, duration, score);
        }

        return movie;
    }

    public void createMovie(Movie movie) throws SQLException {
        String createMovieSQL = "INSERT INTO Movies (Title, ReleaseDate, Duration, Score) VALUES (\'" +
                movie.getTitle() + "\', strftime(\'%Y-%m-%d\',\'" +
                movie.getReleaseDate() + "\'), time(\'" +
                movie.getDuration() + "\')," +
                movie.getScore() + ");";

        statement.execute(createMovieSQL);
    }

    public void deleteMovieFromId(int id) throws SQLException {
        String deleteMovieSQL = "DELETE FROM Movies WHERE Id=" + id + ";";

        statement.execute(deleteMovieSQL);
    }
}
