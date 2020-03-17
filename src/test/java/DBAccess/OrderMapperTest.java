package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class OrderMapperTest {

    private static Connection testConnection;
    private static String USER = "testinguser";
    private static String USERPW = "try1try2tryAgain";
    private static String DBNAME = "OlskerCupcake";
    private static String HOST = "localhost";

    @Before
    public void setUp() {
        try {
            // awoid making a new connection for each test
            if (testConnection == null) {
                String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
                Class.forName("com.mysql.cj.jdbc.Driver");

                testConnection = DriverManager.getConnection(url, USER, USERPW);
                // Make mappers use test
                Connector.setConnection(testConnection);
            }
            // reset test database
//            try ( Statement stmt = testConnection.createStatement() ) {
//                stmt.execute( "drop table if exists users" );
//                stmt.execute( "create table users like UsersTest" );
//                stmt.execute( "insert into users select * from UsersTest" );
//            }

        } catch (ClassNotFoundException | SQLException ex) {
            testConnection = null;
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }
    }
}