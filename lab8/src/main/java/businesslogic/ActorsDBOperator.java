package businesslogic;

import dbconn.DBConnectionSingleton;
import dbconn.DBConnectionHikari;
import models.Actor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ActorsDBOperator {

    private Statement statement;

    public ActorsDBOperator() throws SQLException {
        statement = DBConnectionSingleton.getInstance()
                .connection
                .createStatement();
    }

    public ActorsDBOperator(String url) throws SQLException {
        statement = (new DBConnectionHikari()).getConnection()
                .createStatement();
    }

    public List<Actor> getAllActors() throws SQLException {
        List<Actor> allActors = new ArrayList<>();

        String getAllActorsSQL = "SELECT * FROM Actors;";
        ResultSet result = statement.executeQuery(getAllActorsSQL);

        while (result.next()) {
            int id = Integer.parseInt(result.getString(1));
            String name = result.getString(2);
            int fromMovie = result.getInt(3);
            Actor currentActor = new Actor(id, name, fromMovie);
            allActors.add(currentActor);
        }
        return allActors;
    }

    public Actor getActorById(int id) throws SQLException {
        Actor actor = null;

        String getActorByIdSQL = "SELECT * FROM Actors WHERE Id=" + id + ";";
        ResultSet result = statement.executeQuery(getActorByIdSQL);

        if (result.next()) {
            String name = result.getString(2);
            int fromMovie = result.getInt(3);
            actor = new Actor(id, name, fromMovie);
        }

        return actor;
    }

    public Actor getActorByName(String name) throws SQLException {
        Actor actor = null;

        String getActorByIdSQL = "SELECT * FROM Actors WHERE Name=" + name + ";";
        ResultSet result = statement.executeQuery(getActorByIdSQL);

        if (result.next()) {
            int id = Integer.parseInt(result.getString(1));
            int fromMovie = result.getInt(3);
            actor = new Actor(id, name, fromMovie);
        }

        return actor;
    }

    public void createActor(Actor actor) throws SQLException {
        String createActorSQL = "INSERT INTO Actors (Name, MovieId) VALUES (\'"
                + actor.getName() + "\', "
                + actor.getFromMovie() + ");";

        statement.execute(createActorSQL);
    }

    public void deleteActorFromId(int id) throws SQLException {
        String deleteActorSQL = "DELETE FROM Actors WHERE Id=" + id + ";";

        statement.execute(deleteActorSQL);
    }

}
