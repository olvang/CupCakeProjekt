package DBAccess;

import FunctionLayer.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class OrderMapperTest {

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
    public void testSaveOrder() {
        User cusomter = new User("admin@admin.com","admin",true,100);
        cusomter.setId(5);
        Order ord = new Order();
        ord.setCustomer(cusomter);
        ord.setPickupDate(new Date());

        Bottom bot = new Bottom(1,"Chocolate",5.0);
        Topping top = new Topping(1,"Chocolate", 5.0);

        ord.addToOrder(bot, top, 1);
        ord.addToOrder(bot, top, 2);

        OrderMapper.saveOrder(ord);
    }
}