package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import PresentationLayer.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 * The purpose of UserMapper is to...
 *
 * @author kasper
 */
public class UserMapper {

    public static void createUser(User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO users (email, password, admin, balance) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setBoolean(3, user.isAdmin());
            ps.setDouble(4, 0.0);
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT u_id, admin, balance FROM users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                boolean role = rs.getBoolean("admin");
                int id = rs.getInt("u_id");
                double balance = rs.getDouble("balance");
                User user = new User(email, password, role, balance);
                user.setId(id);
                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User getUser(int userID) throws LoginSampleException {
        User user = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT email, admin, balance " +
                    "FROM users WHERE u_id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String email = rs.getString("email");
                boolean admin = rs.getBoolean("admin");
                double balance = rs.getDouble("balance");

                user = new User(email, admin, balance);
                user.setId(userID);
            } else {
                throw new LoginSampleException("User does not exist");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new LoginSampleException(e.getMessage());
        }
        return user;
    }

    public static ArrayList<User> getAllCustomers() throws LoginSampleException {
        ArrayList<User> customers = new ArrayList();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT u_id, email, balance " +
                    "FROM users WHERE admin = 0";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            //first check if there are any rows at all
            if (rs.next()) {
                do {
                    int id = rs.getInt("u_id");
                    String email = rs.getString("email");
                    double balance = rs.getDouble("balance");
                    User user = new User(email, false, balance);
                    user.setId(id);
                    customers.add(user);
                //check while after, to avoid missing first row due to if statement
                } while (rs.next());
            }else {
                throw new LoginSampleException("There are no customers");
            }

        } catch (SQLException | ClassNotFoundException | LoginSampleException e) {
            throw new LoginSampleException(e.getMessage());
        }
        return customers;
    }

    public static void updateUser(User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL;
            PreparedStatement ps;

            //If password hasn't been set, it shouldn't be changed
            //This check is neccesary because the current password
            // isn't pulled from the database when showing all customers
            // for security reasons.
            if (user.getPassword() == null) {
                SQL = "UPDATE users SET email = ?, balance = ? " +
                        "WHERE u_id = ?";
                ps = con.prepareStatement( SQL );
                ps.setString(1, user.getEmail());
                ps.setDouble(2, user.getBalance());
                ps.setInt(3, user.getId());
            } else {
                SQL = "UPDATE users SET password = ?, email = ?, balance = ? " +
                        "WHERE u_id = ?";
                ps = con.prepareStatement( SQL );
                ps.setString(1, user.getPassword());
                ps.setString(2, user.getEmail());
                ps.setDouble(3, user.getBalance());
                ps.setInt(4, user.getId());
            }
            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0) {
                throw new LoginSampleException( "User does not exist" );
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new LoginSampleException( "Unknown SQL error" );
        }
    }
}


