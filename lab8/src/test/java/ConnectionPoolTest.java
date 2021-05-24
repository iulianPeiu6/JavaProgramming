import businesslogic.DirectorsDBOperator;
import models.Director;

import java.sql.SQLException;

public class ConnectionPoolTest implements Runnable {


    private DirectorsDBOperator directorsDBOperator;

    public ConnectionPoolTest(DirectorsDBOperator directorsDBOperator) {
        this.directorsDBOperator = directorsDBOperator;
    }

    @Override
    public void run() {
        try {
            directorsDBOperator.createDirector(new Director("director",6));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
