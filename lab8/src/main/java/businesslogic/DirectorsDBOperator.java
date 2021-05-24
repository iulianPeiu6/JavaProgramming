package businesslogic;

import dbconn.DBConnectionSingleton;
import dbconn.DBConnectionHikari;
import models.Director;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DirectorsDBOperator {

    private Statement statement;

    public DirectorsDBOperator() throws SQLException {
        statement = DBConnectionSingleton.getInstance()
                .connection
                .createStatement();
    }

    public DirectorsDBOperator(String url) throws SQLException {
        statement = (new DBConnectionHikari()).getConnection()
                .createStatement();
    }

    public List<Director> getAllDirectors() throws SQLException {
        List<Director> allDirectors = new ArrayList<>();

        String getAllDirectorsSQL = "SELECT * FROM Directors;";
        ResultSet result = statement.executeQuery(getAllDirectorsSQL);

        while (result.next()) {
            int id = Integer.parseInt(result.getString(1));
            String name = result.getString(2);
            int ofMovie = result.getInt(3);
            Director currentDirector = new Director(id, name, ofMovie);
            allDirectors.add(currentDirector);
        }
        return allDirectors;
    }

    public Director getDirectorById(int id) throws SQLException {
        Director director = null;

        String getDirectorByIdSQL = "SELECT * FROM Directors WHERE Id=" + id + ";";
        ResultSet result = statement.executeQuery(getDirectorByIdSQL);

        if (result.next()) {
            String name = result.getString(2);
            int ofMovie = result.getInt(3);
            director = new Director(id, name, ofMovie);
        }

        return director;
    }

    public Director getDirectorByName(String name) throws SQLException {
        Director director = null;

        String getDirectorByIdSQL = "SELECT * FROM Directors WHERE Name=" + name + ";";
        ResultSet result = statement.executeQuery(getDirectorByIdSQL);

        if (result.next()) {
            int id = Integer.parseInt(result.getString(1));
            int ofMovie = result.getInt(3);
            director = new Director(id, name, ofMovie);
        }

        return director;
    }

    public void createDirector(Director director) throws SQLException {
        String createDirectorSQL = "INSERT INTO Directors (Name, MovieId) VALUES (\'"
                + director.getName() + "\', "
                + director.getOfMovie() + ");";

        statement.execute(createDirectorSQL);
    }

    public void deleteDirectorFromId(int id) throws SQLException {
        String deleteDirectorSQL = "DELETE FROM Directors WHERE Id=" + id + ";";

        statement.execute(deleteDirectorSQL);
    }
}
