package FunctionLayer;

import java.util.ArrayList;

/**
 * The purpose of User is to...
 * @author kasper
 */
public class User {

    public User( String email, String password, String role, double balance ) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.balance = balance;
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password; // Should be hashed and secured
    private String role;
    private double balance;

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole( String role ) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public ArrayList<Order> getUserOrders(int userID){
        return null;
    }

    public User updateUser(int userID){
        return null;
    }

    public User getUser(int userID){
        return null;
    }

    public ArrayList<User> getAllCustomers(){
        return null;
    }
}
