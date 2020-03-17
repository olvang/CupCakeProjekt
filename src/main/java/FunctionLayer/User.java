package FunctionLayer;

import DBAccess.UserMapper;

import java.util.ArrayList;

/**
 * The purpose of User is to...
 * @author kasper
 */
public class User {

    public User( String email, String password, boolean admin, double balance ) {
        this.email = email;
        this.password = password;
        this.admin = admin;
        this.balance = balance;
    }

    public User(String email, boolean admin, double balance) {
        this.email = email;
        this.admin = admin;
        this.balance = balance;
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password; // Should be hashed and secured
    private boolean admin;
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

    public boolean isAdmin() {
        return admin;
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

    public double getBalance() {
        return balance;
    }

    public void updateUser(User user) throws LoginSampleException {
        UserMapper.updateUser(user);
    }

    public User getUser(int userID){
        return null;
    }

    public ArrayList<User> getAllCustomers(){
        return null;
    }

    public void setBalance(double balance) {

        this.balance = balance;
    }
}
