package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import testsetup.TestDataSetup;

public class UserMapperTest extends TestDataSetup {

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
//            try ( Statement stmt = testConnection.createStatement() ) {
//                stmt.execute( "drop table if exists users" );
//                stmt.execute( "create table users like UsersTest" );
//                stmt.execute( "insert into users select * from UsersTest" );
//            }

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
    public void testLogin01() throws LoginSampleException {
        // Can we log in
        User user = UserMapper.login( "someone@nowhere.com", "a1234" );
        assertTrue( user != null );
    }

    @Test( expected = LoginSampleException.class )
    public void testLogin02() throws LoginSampleException {
        // We should get an exception if we use the wrong password
        User user = UserMapper.login( "jensen@nowhere.com", "larsen" );
    }

    @Test
    public void testLogin03() throws LoginSampleException {
        // Hansen is supposed to be a customer
        User user = UserMapper.login( "hansen@nowhere.com", "d1234" );
        assertEquals( false, user.isAdmin() );
    }

    @Test
    public void testCreateUser01() throws LoginSampleException {
        // Can we create a new user - Notice, if login fails, this will fail
        // but so would login01, so this is OK
        User original = new User( "king@kong.com", "uhahvorhemmeligt", true,0 );
        UserMapper.createUser( original );
        User retrieved = UserMapper.login( "king@kong.com", "uhahvorhemmeligt" );
        assertEquals( true, retrieved.isAdmin() );
    }

    @Test
    public void testGetUser() throws LoginSampleException {
        int id = 2;
        String expectedEmail = "jensen@nowhere.com";
        double expectedBalance = 0;

        User user = UserMapper.getUser(id);

        assertEquals(expectedEmail, user.getEmail());
        assertFalse(user.isAdmin());
        assertEquals(expectedBalance, user.getBalance(), 0.01);
    }

    @Test (expected = LoginSampleException.class)
    public void testGetNonExistingUser() throws LoginSampleException {
        UserMapper.getUser(22);
    }

    @Test (expected = LoginSampleException.class)
    public void testGetAllCustomersIfNoCustomers() throws LoginSampleException {
        try (Statement stmt = Connector.connection().createStatement()) {
            stmt.execute("TRUNCATE TABLE users;" );
            UserMapper.getAllCustomers();
        } catch (SQLException |ClassNotFoundException  e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAllCustomersBySize() throws LoginSampleException {
        ArrayList<User> customers = UserMapper.getAllCustomers();
        int expectedSize = 4;
        assertEquals(expectedSize, customers.size());
    }

    @Test
    public void testUpdateUserNoPassword() throws LoginSampleException {
        User user = UserMapper.getUser(2);
        user.setEmail("jensen@gmail.com");
        user.setBalance(31415);

        UserMapper.updateUser(user);
        User returnedUser = UserMapper.getUser(2);

        assertEquals(returnedUser.getEmail(), user.getEmail());
        assertEquals(returnedUser.getBalance(), user.getBalance(), 0.01);
        assertNull(returnedUser.getPassword());
    }

    @Test
    public void testUpdateUserWithPassword() throws LoginSampleException {
        User user = UserMapper.getUser(2);
        String email = "jensen@gmail.com";
        String password = "nytpassword";
        user.setEmail(email);
        user.setBalance(1234.56);
        user.setPassword(password);

        UserMapper.updateUser(user);
        User returnedUser = UserMapper.login(email, password);

        assertEquals(returnedUser.getEmail(), user.getEmail());
        assertEquals(returnedUser.getBalance(), user.getBalance(), 0.01);
        assertEquals(returnedUser.getPassword(), user.getPassword());
    }

    @Test (expected = LoginSampleException.class)
    public void testUpdateNonExistingUser() throws LoginSampleException {
        User user = new User("peter@peter.peter",
                "peterspassword", true, 2000000);
        user.setId(23);
        UserMapper.updateUser(user);
    }

}
