package businesslogic;

import dbconn.DBConnectionSingleton;
import dbconn.DBConnectionHikari;
import models.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GenresDBOperator {

    private Statement statement;

    public GenresDBOperator() throws SQLException {
        statement = DBConnectionSingleton.getInstance()
                .connection
                .createStatement();
    }

    public GenresDBOperator(String url) throws SQLException {
        statement = (new DBConnectionHikari()).getConnection()
                .createStatement();
    }

    public List<Genre> getAllGenres() throws SQLException {
        List<Genre> allGenres = new ArrayList<>();

        String getAllGenresSQL = "SELECT * FROM Genres;";
        ResultSet result = statement.executeQuery(getAllGenresSQL);

        while (result.next()) {
            int id = Integer.parseInt(result.getString(1));
            String name = result.getString(2);
            Genre currentGenre = new Genre(id, name);
            allGenres.add(currentGenre);
        }
        return allGenres;
    }

    public Genre getGenreById(int id) throws SQLException {
        Genre genre = null;

        String getGenreByIdSQL = "SELECT * FROM Genres WHERE Id=" + id + ";";
        ResultSet result = statement.executeQuery(getGenreByIdSQL);

        if (result.next()) {
            String name = result.getString(2);
            genre = new Genre(id, name);
        }

        return genre;
    }

    public Genre getGenreByName(String name) throws SQLException {
        Genre genre = null;

        String getGenreByNameSQL = "SELECT * FROM Genres WHERE Name=\'" + name + "\';";
        ResultSet result = statement.executeQuery(getGenreByNameSQL);

        if (result.next()) {
            int id = Integer.parseInt(result.getString(1));
            genre = new Genre(id, name);
        }

        return genre;
    }

    public void createGenre(Genre genre) throws SQLException {
        String createGenreSQL = "INSERT INTO Genres (Name) VALUES (\'" + genre.getName() + "\' );";

        statement.execute(createGenreSQL);
    }

    public void deleteGenreFromId(int id) throws SQLException {
        String deleteGenreSQL = "DELETE FROM Genres WHERE Id=" + id + ";";

        statement.execute(deleteGenreSQL);
    }

}
