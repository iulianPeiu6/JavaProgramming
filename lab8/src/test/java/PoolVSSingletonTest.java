import businesslogic.DirectorsDBOperator;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class PoolVSSingletonTest {

    @Test
    public void getPoolConnTime() throws SQLException {
        long start = System.currentTimeMillis();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);

        for (int i = 0; i <= 64 * 64; i++) {
            ConnectionPoolTest pooVSSingletonTest = new ConnectionPoolTest(new DirectorsDBOperator("Hikari"));
            executor.execute(pooVSSingletonTest);
        }
        executor.shutdown();
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }

    @Test
    public void getSingletonConnTime() throws SQLException {
        long start = System.currentTimeMillis();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);

        for (int i = 0; i <= 64 * 64; i++) {
            ConnectionPoolTest pooVSSingletonTest = new ConnectionPoolTest(new DirectorsDBOperator());
            executor.execute(pooVSSingletonTest);
        }
        executor.shutdown();
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }

    @Test
    public void printStatistics() throws SQLException {
        getPoolConnTime();
        getSingletonConnTime();
    }


}
