package DBAccess;

import FunctionLayer.Staistics;
import com.sun.org.glassfish.external.statistics.Statistic;
import org.junit.Before;
import org.junit.Test;
import testsetup.TestDataSetup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StatisticsMapperTest extends TestDataSetup {

    private static Connection testConnection;
    private static String USER = "mario";
    private static String USERPW = "mario123";
    private static String DBNAME = "OlskerCupcake";
    private static String HOST = "localhost";

    @Before
    public void setUp() {
        try {
            // awoid making a new connection for each test
            if (testConnection == null) {
                String url = String.format("jdbc:mysql://%s:3306/%s?serverTimezone=UTC", HOST, DBNAME);
                Class.forName("com.mysql.cj.jdbc.Driver");

                testConnection = DriverManager.getConnection(url, USER, USERPW);
                // Make mappers use test
                Connector.setConnection(testConnection);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            testConnection = null;
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }
    }
    @Test
    public void testGetAmountOfOrders() {
        int expected = 5;
        int actual = StatisticsMapper.getAmountOfOrders();

        assertEquals( expected,actual);
    }
    @Test
    public void testGetAmountOfCupcakes() {
        int expected = 20;
        int actual = StatisticsMapper.getAmountOfCupcakes();

        assertEquals( expected,actual);
    }
    @Test
    public void testGetAmountOfUsers() {
        int expected = 5;
        int actual = StatisticsMapper.getAmountOfUsers();

        assertEquals( expected,actual);
    }
    @Test
    public void testTotalSale() {
        int expected = 260;
        int actual = StatisticsMapper.getTotalSale();

        assertEquals( expected,actual);
    }
    @Test
    public void testGetLast5(){
        int expected = 5;
        int actual = StatisticsMapper.getLast5().size();
        for (Staistics stats: StatisticsMapper.getLast5()) {
            System.out.println(stats);
        }
        assertEquals(expected,actual);
    }
}
