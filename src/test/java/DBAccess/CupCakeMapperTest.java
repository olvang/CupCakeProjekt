package DBAccess;

import FunctionLayer.*;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CupCakeMapperTest {
//    Test date in the UsersTest table
//    INSERT INTO `UsersTest` VALUES 
//    (1,'jens@somewhere.com','jensen','customer'),
//    (2,'ken@somewhere.com','kensen','customer'),
//    (3,'robin@somewhere.com','batman','employee'),
//    (4,'someone@nowhere.com','sesam','customer');

    private static Connection testConnection;
    private static String USER = "testinguser";
    private static String USERPW = "try1try2tryAgain";
    private static String DBNAME = "OlskerCupcake";
    private static String HOST = "localhost";

    @Before
    public void setUp() {
        try {
            // awoid making a new connection for each test
            if ( testConnection == null ) {
                String url = String.format( "jdbc:mysql://%s:3306/%s", HOST, DBNAME );
                Class.forName( "com.mysql.cj.jdbc.Driver" );

                testConnection = DriverManager.getConnection( url, USER, USERPW );
                // Make mappers use test 
                Connector.setConnection( testConnection );
            }
            // reset test database
           /* try ( Statement stmt = testConnection.createStatement() ) {
                stmt.execute( "drop table if exists users" );
                stmt.execute( "create table users like UsersTest" );
                stmt.execute( "insert into users select * from UsersTest" );
            }*/

        } catch ( ClassNotFoundException | SQLException ex ) {
            testConnection = null;
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }

    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull( testConnection );
    }

    @Test
    public void testGetTopAndBottoms() {
        TopAndBottoms catalog = new CupCakeMapper().getTopAndBottoms();
        int testIndex = 2;
        String expectedBottomName;
        String actualBottomName;
        String expectedToppingName;
        String actualToppingName;
        double expectedBottomPrice;
        double actualBottomPrice;
        double expectedToppingPrice;
        double actualToppingPrice;

        //Act bottoms
        expectedBottomName = "Nutmeg";
        actualBottomName = catalog.getBottoms().get(testIndex).getName();
        expectedBottomPrice = 5.0;
        actualBottomPrice = catalog.getBottoms().get(testIndex).getPrice();

        //Act toppings
        expectedToppingName = "Rasberry";
        actualToppingName = catalog.getToppings().get(testIndex).getName();
        expectedToppingPrice = 5.0;
        actualToppingPrice = catalog.getToppings().get(testIndex).getPrice();

        //Assert
        assertEquals(expectedBottomName, actualBottomName);
        assertEquals(expectedBottomPrice, actualBottomPrice, 0.01);
        assertEquals(expectedToppingName, actualToppingName);
        assertEquals(expectedToppingPrice, actualToppingPrice, 0.01);
    }

    @Test
    public void testGetBottoms() {
        ArrayList<Bottom> bottoms = CupCakeMapper.getBottoms();
        int testIndex = 2;
        String expectedBottomName;
        String actualBottomName;
        double expectedBottomPrice;
        double actualBottomPrice;

        //Act bottoms
        expectedBottomName = "Nutmeg";
        actualBottomName = bottoms.get(testIndex).getName();
        expectedBottomPrice = 5.0;
        actualBottomPrice = bottoms.get(testIndex).getPrice();

        //Assert
        assertEquals(expectedBottomName, actualBottomName);
        assertEquals(expectedBottomPrice, actualBottomPrice, 0.01);
    }

    @Test
    public void testGetToppings() {
        ArrayList<Topping> toppings = CupCakeMapper.getToppings();
        int testIndex = 2;
        String expectedToppingName;
        String actualToppingName;
        double expectedToppingPrice;
        double actualToppingPrice;

        //Act
        expectedToppingName = "Rasberry";
        actualToppingName = toppings.get(testIndex).getName();
        expectedToppingPrice = 5.0;
        actualToppingPrice = toppings.get(testIndex).getPrice();

        //Assert
        assertEquals(expectedToppingName, actualToppingName);
        assertEquals(expectedToppingPrice, actualToppingPrice, 0.01);
    }
}
